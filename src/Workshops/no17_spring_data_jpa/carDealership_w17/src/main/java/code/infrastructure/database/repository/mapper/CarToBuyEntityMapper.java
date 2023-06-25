package code.infrastructure.database.repository.mapper;

import code.domain.CarToBuy;
import code.infrastructure.database.entity.CarToBuyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarToBuyEntityMapper {

    // trzeba dopisać ignorowanie bo w mapowaniu entity invoice jest ustawione jako fetchType.Lazy
    // więc mapstruct próbowałby getterem wziąć fakture i wyrzuciłoby wyjątek
    @Mapping(target = "invoice", ignore = true)
    CarToBuy mapFromEntity(CarToBuyEntity entity);
}
