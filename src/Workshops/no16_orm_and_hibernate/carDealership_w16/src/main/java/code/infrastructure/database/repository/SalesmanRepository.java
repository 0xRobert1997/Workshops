package code.infrastructure.database.repository;

import code.business.dao.SalesmanDAO;
import code.infrastructure.configuration.HibernateUtil;
import code.infrastructure.database.entity.SalesmanEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class SalesmanRepository implements SalesmanDAO {


    @Override
    public Optional<SalesmanEntity> findSalesmanByPesel(String pesel) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String query = "SELECT se FROM SalesmanEntity se WHERE se.pesel = :pesel";
            Optional<SalesmanEntity> result = session.createQuery(query, SalesmanEntity.class)
                    .setParameter("pesel", pesel)
                    .uniqueResultOptional();


            session.getTransaction().commit();
            return result;
        }
    }
}
