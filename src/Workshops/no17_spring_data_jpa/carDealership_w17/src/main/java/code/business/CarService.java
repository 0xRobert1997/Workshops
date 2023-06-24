package code.business;

import code.business.dao.CarDAO;
import code.domain.CarHistory;
import code.domain.CarToBuy;
import code.domain.CarToService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CarService {

    private final CarDAO carDAO;

    public CarToBuy findCarToBuy(String vin) {
        Optional<CarToBuy> carToBuyByVin = carDAO.findCarToBuyByVin(vin);
        if (carToBuyByVin.isEmpty()) {
            throw new RuntimeException("Could not find car by vin: [%s]".formatted(vin));
        }
        return carToBuyByVin.get();
    }

    public Optional<CarToService> findCarToService(String vin) {
        return carDAO.findCarToServiceByVin(vin);
    }

    public Optional<CarToService> findCatToService(String vin) {
        return carDAO.findCarToServiceByVin(vin);
    }

    public CarToService saveCarToService(CarToBuy carToBuy) {
        CarToService carToService = CarToService.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carDAO.saveCarToService(carToService);
    }

    public CarToService saveCarToService(CarToService car) {
        CarToService carToService = CarToService.builder()
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
        return carDAO.saveCarToService(carToService);
    }


    public void printCarHistory(String vin) {
        CarHistory carHistoryByVin = carDAO.findCarHistoryByVin(vin);
        log.info("###CAR HISTORY FOR VIN: [{}]", vin);
        carHistoryByVin.getCarServiceRequests().forEach(this::printServiceRequest);
    }

    private void printServiceRequest(CarHistory.CarServiceRequest serviceRequest) {
        log.info("###SERVICE REQUEST: [{}]", serviceRequest);
        serviceRequest.getServices().forEach(service -> log.info("###SERVICE: [{}]", service));
        serviceRequest.getParts().forEach(part -> log.info("###PART: [{}]", part));
    }
}