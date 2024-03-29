package code.infrastructure.database.repository.mapper;

import code.domain.Mechanic;
import code.infrastructure.database.entity.MechanicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MechanicEntityMapper {


    @Mapping(target = "serviceMechanics", ignore = true)
    Mechanic mapFromEntity(MechanicEntity entity);
}
