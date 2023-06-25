package code.infrastructure.database.repository.mapper;

import code.domain.Service;
import code.infrastructure.database.entity.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceEntityMapper {

    @Mapping(target = "serviceMechanics", ignore = true)
    Service mapFromEntity(ServiceEntity entity);
}
