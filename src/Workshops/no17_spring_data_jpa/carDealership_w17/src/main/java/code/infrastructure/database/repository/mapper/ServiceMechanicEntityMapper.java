package code.infrastructure.database.repository.mapper;

import code.domain.ServiceMechanic;
import code.infrastructure.database.entity.ServiceMechanicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMechanicEntityMapper {

    ServiceMechanicEntity mapToEntity(ServiceMechanic serviceMechanic);
}
