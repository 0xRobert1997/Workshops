package code.cache;

import code.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import java.util.Objects;
import java.util.Optional;

public class CachedEmployeeRepository {

    CachedEmployee insertData(final CachedEmployee cachedEmployee) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(cachedEmployee);
            session.getTransaction().commit();
            return cachedEmployee;
        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String query = "select employee from Employee employee";
            session.createQuery(query, code.manyToMany.Employee.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

    void l1c(Long employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e1 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E1 %s %s%n", e1.getName(), e1.getSurname());

            CachedEmployee e2 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E2 %s %s%n", e2.getName(), e2.getSurname());

            session.evict(e1);

            CachedEmployee e3 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E3 %s %s%n", e3.getName(), e3.getSurname());

            CachedEmployee e4 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E4 %s %s%n", e4.getName(), e4.getSurname());

            session.clear();

            CachedEmployee e5 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E5 %s %s%n", e5.getName(), e5.getSurname());

            session.getTransaction().commit();
        }
    }

    Optional<CachedEmployee> l2c(int employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e1 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("###E1 %s %s%n", e1.getName(), e1.getSurname());

            stats(HibernateUtil.getStatistic());

            session.getTransaction().commit();

            return Optional.of(e1);
        }
    }

    private void stats(Statistics statistics) {
        System.out.println("Misses in 2LC: " + statistics.getSecondLevelCacheMissCount());
        System.out.println("Added to 2LC: " + statistics.getSecondLevelCachePutCount());
        System.out.println("Found in 2LC: " + statistics.getSecondLevelCacheHitCount());
    }
}
