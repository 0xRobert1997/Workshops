package code.infrastructure.database.repository;

import code.business.dao.ServiceRequestProcessingDAO;
import code.domain.CarServiceRequest;
import code.domain.ServiceMechanic;
import code.domain.ServicePart;
import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.PartEntity;
import code.infrastructure.database.entity.ServiceMechanicEntity;
import code.infrastructure.database.entity.ServicePartEntity;
import code.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import code.infrastructure.database.repository.jpa.PartJpaRepository;
import code.infrastructure.database.repository.jpa.ServiceMechanicJpaRepository;
import code.infrastructure.database.repository.jpa.ServicePartJpaRepository;
import code.infrastructure.database.repository.mapper.ServiceMechanicEntityMapper;
import code.infrastructure.database.repository.mapper.ServicePartEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {

    private final ServiceMechanicJpaRepository serviceMechanicJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final PartJpaRepository partJpaRepository;
    private final ServicePartJpaRepository servicePartJpaRepository;

    private final ServiceMechanicEntityMapper serviceMechanicEntityMapper;
    private final ServicePartEntityMapper servicePartEntityMapper;
    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic
    ) {
        ServiceMechanicEntity serviceMechanicEntity = serviceMechanicEntityMapper.mapToEntity(serviceMechanic);
        serviceMechanicJpaRepository.saveAndFlush(serviceMechanicEntity);
        if (Objects.nonNull(serviceRequest.getCompletedDateTime())) {
            CarServiceRequestEntity carServiceRequestEntity = carServiceRequestJpaRepository.findById(serviceRequest.getCarServiceRequestId())
                    .orElseThrow();
            carServiceRequestEntity.setCompletedDateTime(serviceRequest.getCompletedDateTime());
            carServiceRequestJpaRepository.saveAndFlush(carServiceRequestEntity);
        }
    }

    @Override
    public void process(
            CarServiceRequest serviceRequest,
            ServiceMechanic serviceMechanic,
            ServicePart servicePart
    ) {
        PartEntity partEntity = partJpaRepository.findById(servicePart.getPart().getPartId()).orElseThrow();
        ServicePartEntity servicePartEntity = servicePartEntityMapper.mapToEntity(servicePart);
        servicePartEntity.setPart(partEntity);
        servicePartJpaRepository.saveAndFlush(servicePartEntity);
        process(serviceRequest, serviceMechanic);
    }
}
