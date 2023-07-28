package pl.zajavka.controller.integration.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;


import pl.zajavka.controller.integration.support.AuthenticationTestSupport;
import pl.zajavka.controller.integration.support.ControllerTestSupport;

public abstract class RestAssuredIntegrationTestBase
        extends AbstractIntegrationTest
        implements ControllerTestSupport, AuthenticationTestSupport {

    @LocalServerPort
    private int serverPort;

    @Value("${server.servlet.context-path}") //wyciąga wartość context-path z pliku yaml
    private String basePath;

    protected static WireMockServer wireMockServer;
    private String jSessionIdValue;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() {
        wireMockServer = new WireMockServer(
                WireMockConfiguration.wireMockConfig()
                        .port(9999)
                        .extensions(new ResponseTemplateTransformer(false))
        );
        wireMockServer.start();
    }

    // Przed każdym testem się loguje i zwraca ciastko które można użyć w teście
    @BeforeEach
    void beforeEach() {
        jSessionIdValue = login("User1", "test")
                .and()
                .cookie("JSESSIONID")
                .header(HttpHeaders.LOCATION, "http://localhost:%s%s/".formatted(serverPort, basePath))
                .extract()
                .cookie("JSESSIONID");
    }

    @AfterEach
    void afterEach() {
        logout()
                .and()
                        .cookie("JSESSIONID", "");
        jSessionIdValue = null;
        wireMockServer.resetAll(); // resetuje konfiguracje wszystkich mocków po każdym teście
    }

    @AfterAll
    static void afterAll() {
        wireMockServer.stop();
    }

    @Test
    void contextLoad() {
        Assertions.assertTrue(true, "Context loaded");
    }



    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public RequestSpecification requestSpecification() {
        return restAssuredBase()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .cookie("JSESSIONID", jSessionIdValue);
    }

    public RequestSpecification requestSpecificationNoAuthorization() {
        return restAssuredBase();
    }

    private RequestSpecification restAssuredBase() {
        return RestAssured
                .given()
                .config(getConfig())
                .basePath(basePath)
                .port(serverPort);
    }


    private RestAssuredConfig getConfig() {
        return RestAssuredConfig
                .config()
                .objectMapperConfig(new ObjectMapperConfig()
                        .jackson2ObjectMapperFactory((p1, p2) -> objectMapper));
    }
}
