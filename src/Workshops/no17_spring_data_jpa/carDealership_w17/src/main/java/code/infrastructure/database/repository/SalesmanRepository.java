package code.infrastructure.database.repository;

import code.business.dao.SalesmanDAO;
import code.domain.Salesman;
import code.infrastructure.database.repository.jpa.SalesmanJpaRepository;
import code.infrastructure.database.repository.mapper.SalesmanEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SalesmanRepository implements SalesmanDAO {

    private final SalesmanJpaRepository salesmanJpaRepository;
    private final SalesmanEntityMapper salesmanEntityMapper;


    @Override
    public Optional<Salesman> findByPesel(String pesel) {
        return salesmanJpaRepository.findByPesel(pesel)
                .map(salesmanEntityMapper::mapFromEntity);
    }
}
