package code.infrastructure.database.repository.mapper;

import code.domain.Salesman;
import code.infrastructure.database.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesmanEntityMapper {
    @Mapping(target = "invoices", ignore = true)
    Salesman mapFromEntity(AddressEntity entity);
}
