package code;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JpaExampleTest {

    @Test
    void createAndUpdatePersonTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zajavkaPersistenceUnitExample");

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

        } finally {

        }
    }
}
