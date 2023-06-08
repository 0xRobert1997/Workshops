package code.oneToMany;

import code.HibernateUtil;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Set;

public class PetRepository {

    Pet insertData(final Pet pet) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(pet);
            session.getTransaction().commit();
            return pet;
        }
    }
}
