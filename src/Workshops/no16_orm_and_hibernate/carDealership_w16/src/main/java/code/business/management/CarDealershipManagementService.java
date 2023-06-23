package code.business.management;

import code.business.dao.management.CarDealershipManagementDAO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CarDealershipManagementService {

    private final CarDealershipManagementDAO carDealershipManagementDAO;

    private final FileDataPreparationService fileDataPreparationService;

    public void purge() {
        carDealershipManagementDAO.purge();
    }

    public void init() {
        List<?> entities = fileDataPreparationService.prepareInitData();
        carDealershipManagementDAO.saveAll(entities);
    }
}
