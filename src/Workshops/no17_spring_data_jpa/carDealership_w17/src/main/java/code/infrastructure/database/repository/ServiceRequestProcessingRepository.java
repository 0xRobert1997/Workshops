package code.infrastructure.database.repository;

import code.business.dao.ServiceRequestProcessingDAO;
import code.infrastructure.configuration.HibernateUtil;
import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.ServiceMechanicEntity;
import code.infrastructure.database.entity.ServicePartEntity;
import org.hibernate.Session;

import java.util.Objects;

public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {
    @Override
    public void process(
            CarServiceRequestEntity serviceRequest,
            ServiceMechanicEntity serviceMechanicEntity
    ) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(serviceMechanicEntity);
            if (Objects.nonNull(serviceRequest.getCompletedDateTime())) {
                session.merge(serviceRequest);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void process(
            CarServiceRequestEntity serviceRequest,
            ServiceMechanicEntity serviceMechanicEntity,
            ServicePartEntity servicePartEntity
    ) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.persist(serviceMechanicEntity);

            session.persist(servicePartEntity);

            if (Objects.nonNull(serviceRequest.getCompletedDateTime())) {
                session.merge(serviceRequest);
            }

            session.getTransaction().commit();
        }
    }
}
