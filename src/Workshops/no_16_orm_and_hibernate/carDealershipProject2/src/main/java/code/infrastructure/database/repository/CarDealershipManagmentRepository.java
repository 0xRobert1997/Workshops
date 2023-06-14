package code.infrastructure.database.repository;

import code.business.dao.management.CarDealershipManagementDAO;
import code.infrastructure.configuration.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;

public class CarDealershipManagmentRepository implements CarDealershipManagementDAO {
    @Override
    public void purge() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.createMutationQuery("DELETE FROM ServiceMechanicEntity ent ").executeUpdate();
            session.createMutationQuery("DELETE FROM ServicePartEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM CarServiceRequestEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM InvoiceEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM MechanicEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM PartEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM ServiceEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM CarToServiceEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM CarToBuyEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM CustomerEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM AddressEntity ent").executeUpdate();
            session.createMutationQuery("DELETE FROM SalesmanEntity ent").executeUpdate();

            session.getTransaction().commit();
        }
    }

    @Override
    public void saveAll(List<?> entities) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            for (var entity : entities) {
                session.persist(entity);
            }

            session.getTransaction().commit();
        }
    }
}
