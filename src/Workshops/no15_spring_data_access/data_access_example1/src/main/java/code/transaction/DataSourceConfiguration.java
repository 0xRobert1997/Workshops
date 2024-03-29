package code.transaction;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ComponentScan(basePackages = "code")
@EnableTransactionManagement // potrzebne do deklaratywnego podeścia do transakcji - czyli z adnotacją @Transactional
public class DataSourceConfiguration {

    @Bean
    public SimpleDriverDataSource databaseDataSource() {
     SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
     dataSource.setDriver(new Driver());
     dataSource.setUrl("jdbc:postgresql://localhost:5432/zajavka");
     dataSource.setUsername("postgres");
     dataSource.setPassword("postgres");
     return dataSource;
    }

    // potrzebne do obu sposobów obługi transakcji
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(databaseDataSource());
    }
/*
    // do programowalnego zarządzania transakcją za pomocą TransactionTemplate
    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }*/

}
