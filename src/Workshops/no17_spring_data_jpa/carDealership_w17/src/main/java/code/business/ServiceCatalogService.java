package code.business;

import code.business.dao.ServiceDAO;
import code.domain.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ServiceCatalogService {
    private final ServiceDAO serviceDAO;

    public Service findService(String serviceCode) {
        Optional<Service> service = serviceDAO.findByServiceCode(serviceCode);
        if (service.isEmpty()) {
            throw new RuntimeException("Could not find service by service code: [%s]".formatted(serviceCode));
        }
        return service.get();
    }
}
