package code.business;

import code.business.dao.SalesmanDAO;
import code.domain.Salesman;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SalesmanService {
    private final SalesmanDAO salesmanDAO;

    public Salesman findSalesman(String pesel) {
        Optional<Salesman> salesman = salesmanDAO.findSalesmanByPesel(pesel);
        if (salesman.isEmpty()) {
            throw new RuntimeException("Could not find salesman by pesel: [%s]".formatted(pesel));
        }
        return salesman.get();
    }
}
