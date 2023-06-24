package code.business;

import code.business.dao.PartDAO;
import code.domain.Part;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PartCatalogService {
    private final PartDAO partDAO;

    public Part findPart(String partSerialNumber) {
        Optional<Part> part = partDAO.findBySerialNumber(partSerialNumber);
        if (part.isEmpty()) {
            throw new RuntimeException("Could not find part by part serial number: [%s]".formatted(partSerialNumber));
        }
        return part.get();
    }

}
