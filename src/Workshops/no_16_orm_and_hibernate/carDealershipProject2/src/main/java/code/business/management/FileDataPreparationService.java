package code.business.management;

import code.infrastructure.database.entity.*;

import java.util.List;
import java.util.stream.Stream;

public class FileDataPreparationService {
    public List<?> prepareInitData() {

        List<SalesmanEntity> salesmen = InputDataCache
                .getInputData(Keys.InputDataGroup.INIT, Keys.Entity.SALESMAN, InputDataMapper::mapSalesman);
        List<MechanicEntity> mechanics = InputDataCache
                .getInputData(Keys.InputDataGroup.INIT, Keys.Entity.MECHANIC, InputDataMapper::mapMechanic);
        List<CarToBuyEntity> cars = InputDataCache
                .getInputData(Keys.InputDataGroup.INIT, Keys.Entity.CAR, InputDataMapper::mapCarToBuy);
        List<ServiceEntity> services = InputDataCache
                .getInputData(Keys.InputDataGroup.INIT, Keys.Entity.SERVICE, InputDataMapper::mapService);
        List<PartEntity> parts = InputDataCache
                .getInputData(Keys.InputDataGroup.INIT, Keys.Entity.PART, InputDataMapper::mapPart);


        return Stream.of(salesmen, mechanics, cars,services,parts)
                .flatMap(a -> a.stream())
                .toList();
    }
}
