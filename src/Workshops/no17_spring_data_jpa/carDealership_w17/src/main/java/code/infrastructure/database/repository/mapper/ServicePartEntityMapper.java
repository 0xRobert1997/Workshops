package code.infrastructure.database.repository.mapper;

import code.domain.ServicePart;
import code.infrastructure.database.entity.ServicePartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServicePartEntityMapper {
    ServicePartEntity mapToEntity(ServicePart servicePart);
}
