package code.oneToMany;

import code.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OwnerRepository {

    Owner insertData(final Owner owner, final Set<Pet> pets) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            owner.setPets(pets);
            pets.forEach(pet -> pet.setOwner(owner));
            session.persist(owner);
            session.getTransaction().commit();
            return owner;
        }
    }

    List<Owner> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> getOwner(Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Owner.class, ownerId));
        }
    }

    void update(Integer ownerId, Pet newPet) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            Owner owner = session.find(Owner.class, ownerId);
            owner.getPets().add(newPet);
            session.getTransaction().commit();
        }
    }

    void deleteOwner(Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            session.remove(session.find(Owner.class, ownerId));
            session.getTransaction().commit();
        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            String query = "select owner from Owner owner";
            session.createQuery(query, Owner.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

    int insertHQL() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityManaget is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = """
                    INSERT Owner (name, surname, phone, email)
                    VALUES ('Romek', 'Zabawniacha', '+48 123 123 123', 'romek@zajavka.pl')
                    """;
            Query query = entityManager.createQuery(hql);
            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();

        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return result;
    }

    int updateHQL(final String oldEmail, final String newPhone, final String newEmail) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityManaget is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();

            String hql = """
                    UPDATE Owner ow
                    SET ow.phone = :newPhone, ow.email = :newEmail
                    WHERE ow.email = :oldEmail
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("oldEmail", oldEmail)
                    .setParameter("newPhone", newPhone)
                    .setParameter("newEmail", newEmail);


            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();

        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return result;
    }

    int deleteHQL(final String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityManaget is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();

            String hql = """
                    DELETE FROM Owner ow
                    Where ow.email = :email
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("email", email);


            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();

        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        return result;
    }
    List<Owner> selectExample1() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample2() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String example2 = "SELECT new code.onetomany.OwnerTemp(ow.id, ow.name) FROM Owner as ow";
            List<Owner> owners = session.createQuery(example2, Owner.class).getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample3() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String example3 = "SELECT ow FROM Owner ow WHERE ow.email = :email";
            List<Owner> owners = session
                    .createQuery(example3, Owner.class)
                    .setParameter("email", "adrian@zajavka.pl")
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample4() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String example4 = "SELECT ow FROM Owner ow ORDER BY ow.email ASC, ow.name DESC";
            List<Owner> owners = session
                    .createQuery(example4, Owner.class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    // paginacja
    List<Owner> selectExample5() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String example5 = "SELECT ow FROM Owner ow ORDER BY ow.email DESC";
            List<Owner> owners = session
                    .createQuery(example5, Owner.class)
                    .setFirstResult(0)
                    .setMaxResults(31)
                    .getResultList();

            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> selectExample6(final String name) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String example6 = "SELECT ow FROM Owner ow WHERE ow.name = :name";
            Optional<Owner> owners = session
                    .createQuery(example6, Owner.class)
                    .uniqueResultOptional();
            // jeśli w bazie bd dwie osoby o takim samym imieniu a użyjemy uniqueResultOptional to dostaniemy wyjątek

            session.getTransaction().commit();
            return owners;
        }
    }

    void selectExample7(final String name) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
                                                                // V łączymy na podstawie pola w pets w obiekcie owner
            String select7_1 = "SELECT ow FROM Owner ow INNER JOIN ow.pets pt";
            session.createQuery(select7_1, Owner.class)
                            .getResultList()
                                    .forEach(e -> System.out.println("###Entity: " + e));

            session.getTransaction().commit();

        }
    }



}


