package pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories;

public interface JpaRepositoriesMarker {
    // w PersistenceJPAConfiguration jest adnotacja @EnableJpaRepositories(basePackageClasses = JpaRepositoriesMarker.class)
    // i wszystkie repozytoria muszą znajdować się w paczce z tym markerem
}
