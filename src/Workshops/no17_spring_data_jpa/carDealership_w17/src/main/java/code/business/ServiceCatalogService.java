package code.business;

import code.business.dao.ServiceDAO;
import code.domain.Service;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.Optional;
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceCatalogService {
    private final ServiceDAO serviceDAO;
    @Transactional
    public Service findService(String serviceCode) {
        Optional<Service> service = serviceDAO.findByServiceCode(serviceCode);
        if (service.isEmpty()) {
            throw new RuntimeException("Could not find service by service code: [%s]".formatted(serviceCode));
        }
        return service.get();
    }
}
