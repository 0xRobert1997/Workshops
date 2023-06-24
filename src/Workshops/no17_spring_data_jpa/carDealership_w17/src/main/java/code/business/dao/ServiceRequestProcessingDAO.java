package code.business.dao;

import code.domain.CarServiceRequest;
import code.domain.ServiceMechanic;
import code.domain.ServicePart;


public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequest serviceRequest, ServiceMechanic serviceMechanic);

    void process(CarServiceRequest serviceRequest, ServiceMechanic serviceMechanic, ServicePart servicePart);
}
