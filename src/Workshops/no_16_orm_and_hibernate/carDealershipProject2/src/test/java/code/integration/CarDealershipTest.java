package code.integration;

import code.business.management.CarDealershipManagementService;
import code.business.management.FileDataPreparationService;
import code.infrastructure.configuration.HibernateUtil;
import code.infrastructure.database.repository.CarDealershipManagmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDealershipTest {

    private CarDealershipManagementService carDealershipManagementService;

    @BeforeEach
    void beforeEach() {
        this.carDealershipManagementService = new CarDealershipManagementService(
                new CarDealershipManagmentRepository(),
                new FileDataPreparationService()
        );
    }

    @AfterAll
    static void afterAll() {
        HibernateUtil.closeSessionFactory();
    }

    @Test
    @Order(1)
    void purge() {
        log.info("### RUNNING ORDER 1");
        carDealershipManagementService.purge();
    }

    @Test
    @Order(2)
    void init() {
        log.info("### RUNNING ORDER 2");
    }

    @Test
    @Order(3)
    void purchase() {
        log.info("### RUNNING ORDER 3");
    }

    @Test
    @Order(4)
    void makeServiceRequest() {
        log.info("### RUNNING ORDER 4");
    }

    @Test
    @Order(5)
    void processServiceRequests() {
        log.info("### RUNNING ORDER 5");
    }

    @Test
    @Order(6)
    void printCarHistory() {
        log.info("### RUNNING ORDER 6");
    }
}
