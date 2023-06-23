package code.business;

import code.business.dao.SalesmanDAO;
import code.infrastructure.database.entity.SalesmanEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SalesmanService {
    private final SalesmanDAO salesmanDAO;
    public SalesmanEntity findSalesman(String pesel) {
        Optional<SalesmanEntity> salesman = salesmanDAO.findSalesmanByPesel(pesel);
        if (salesman.isEmpty()) {
            throw new RuntimeException("Could not find salesman by pesel: [%s]".formatted(pesel));
        }
        return salesman.get();
    }
}
