package code.infrastructure.database.repository.mapper;

import code.domain.Customer;
import code.infrastructure.database.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerEntityMapper {


    Customer mapFromEntity(CustomerEntity entity);
    CustomerEntity mapToEntity(Customer customer);
}
