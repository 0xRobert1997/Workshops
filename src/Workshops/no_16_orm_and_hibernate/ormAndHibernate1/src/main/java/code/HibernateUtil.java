package code;

import code.manyToMany.Employee;
import code.manyToMany.Project;
import code.oneToMany.Owner;
import code.oneToMany.Pet;
import code.oneToOne.Address;
import code.oneToOne.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Map;

public class HibernateUtil {

    private static final Map<String, Object> SETTINGS = Map.ofEntries(
            Map.entry(Environment.DRIVER,"org.postgresql.Driver"),
            // dane naszej bazy danych
            Map.entry(Environment.URL,"jdbc:postgresql://localhost:5432/w16"),
            Map.entry(Environment.USER,"postgres"),
            Map.entry(Environment.PASS,"postgres"),
            // dialekt jest zależy od tego jakiej bazy danych używamy
            Map.entry(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect"),
            Map.entry(Environment.HBM2DDL_AUTO,"none"),
            // show sql po to żeby logować zapytania od hibernate i żeby można było to obserwować i optymalizować
            Map.entry(Environment.SHOW_SQL,true),
            // przy format false hibernate będzie logował sql-ki jedno-linijkowo
            Map.entry(Environment.FORMAT_SQL,true)
            );
    private static SessionFactory sessionFactory = loadSessionFactory();

    private static SessionFactory loadSessionFactory() {
        try {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(SETTINGS)
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(Pet.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class)
                    .getMetadataBuilder()
                    .build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static void closeSessionFactory() {
        try {
            sessionFactory.close();
        } catch (Exception e) {
            System.err.println("Exception while closing session facotry: " + e);
        }
    }

    public static Session getSession() {
        try {
            return sessionFactory.openSession();
        } catch (Exception e) {
            System.err.println("Exception while opening session");
        }
        return null;
    }
}
