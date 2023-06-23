package code.business.dao;

import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.ServiceMechanicEntity;
import code.infrastructure.database.entity.ServicePartEntity;

public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequestEntity serviceRequest, ServiceMechanicEntity serviceMechanicEntity);

    void process(CarServiceRequestEntity serviceRequest, ServiceMechanicEntity serviceMechanicEntity, ServicePartEntity servicePartEntity);
}
