package code.infrastructure.database.repository.mapper;

import code.domain.Invoice;
import code.infrastructure.database.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceEntityMapper {
    InvoiceEntity mapToEntity(Invoice entity);
}
