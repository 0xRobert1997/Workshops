package code.infrastructure.database.repository.mapper;

import code.domain.CarHistory;
import code.domain.CarToService;
import code.domain.Part;
import code.domain.Service;
import code.infrastructure.database.entity.CarToServiceEntity;
import code.infrastructure.database.entity.ServiceMechanicEntity;
import code.infrastructure.database.entity.ServicePartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarToServiceEntityMapper {

    @Mapping(target = "carServiceRequests", ignore = true)
    CarToService mapFromEntity(CarToServiceEntity entity);


    default CarHistory mapFromEntity(String vin, CarToServiceEntity entity) {
        return CarHistory.builder()
                .carVin(vin)
                .carServiceRequests(entity.getCarServiceRequests().stream()
                        .map(request -> CarHistory.CarServiceRequest.builder()
                                .carServiceRequestNumber(request.getCarServiceRequestNumber())
                                .receivedDateTime(request.getReceivedDateTime())
                                .completedDateTime(request.getCompletedDateTime())
                                .customerComment(request.getCustomerComment())
                                .services(request.getServiceMechanics().stream()
                                        .map(ServiceMechanicEntity::getService)
                                        .map(service -> Service.builder()
                                                .serviceCode(service.getServiceCode())
                                                .description(service.getDescription())
                                                .price(service.getPrice())
                                                .build())
                                        .toList())
                                .parts(request.getServiceParts().stream()
                                        .map(ServicePartEntity::getPart)
                                        .map(service -> Part.builder()
                                                .serialNumber(service.getSerialNumber())
                                                .description(service.getDescription())
                                                .price(service.getPrice())
                                                .build())
                                        .toList())
                                .build())
                        .toList())
                .build();
    }

    CarToServiceEntity mapToEntity(CarToService car);
}
