package pl.zajavka.controller.integration.support;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import java.util.Map;

public interface WireMockTestSupport {

    default void stubForPet(final WireMockServer wireMockServer, final Long petId) {
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathEqualTo("/pet/%s".formatted(petId))) // endpoint jaki mockuje
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("wiremock/petById.json")                  // nazwa pliku którym odpowie mock
                        .withTransformerParameters(Map.of("petId", petId))          // nazwa parametru w jsonie w tym przypadku "{{parameters.petId}}"
                        .withTransformers("response-template")));

    }
}
