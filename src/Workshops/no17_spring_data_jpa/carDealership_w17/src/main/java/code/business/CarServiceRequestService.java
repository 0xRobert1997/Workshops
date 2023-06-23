package code.business;

import code.business.dao.CarServiceRequestDAO;
import code.domain.CarServiceRequest;
import code.business.management.FileDataPreparationService;
import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.CarToBuyEntity;
import code.infrastructure.database.entity.CarToServiceEntity;
import code.infrastructure.database.entity.CustomerEntity;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CarServiceRequestService {

    private final FileDataPreparationService fileDataPreparationService;
    private final CarService carService;
    private final CustomerService customerService;
    private final CarServiceRequestDAO carServiceRequestDAO;

    public void requestService() {
        Map<Boolean, List<CarServiceRequest>> serviceRequests = fileDataPreparationService.createCarServiceRequests().stream()
                .collect(Collectors.groupingBy(element -> element.getCar().shouldExistInCarToBuy()));

        serviceRequests.get(true).forEach(this::saveServiceRequestsForExistingCar);
        serviceRequests.get(false).forEach(this::saveServiceRequestsForNewCar);
    }

    private void saveServiceRequestsForExistingCar(CarServiceRequest request) {
        CarToServiceEntity car = carService.findCarToService(request.getCar().getVin())
                .orElse(findInCarToBuyAndSaveInCarToService(request.getCar()));
        CustomerEntity customer = customerService.findCustomer(request.getCustomer().getEmail());

        CarServiceRequestEntity carServiceRequestEntity = buildCarServiceRequestEntity(request, car, customer);
        customer.addServiceRequest(carServiceRequestEntity);
        customerService.saveServiceRequest(customer);
    }

    private CarToServiceEntity findInCarToBuyAndSaveInCarToService(CarServiceRequest.Car car) {
        CarToBuyEntity carToBuy = carService.findCarToBuy(car.getVin());
        return carService.saveCarToService(carToBuy);
    }

    private void saveServiceRequestsForNewCar(CarServiceRequest request) {
        CarToServiceEntity car = carService.saveCarToService(request.getCar());
        CustomerEntity customer = customerService.saveCustomer(request.getCustomer());

        CarServiceRequestEntity carServiceRequestEntity = buildCarServiceRequestEntity(request, car, customer);
        customer.addServiceRequest(carServiceRequestEntity);
        customerService.saveServiceRequest(customer);
    }

    private CarServiceRequestEntity buildCarServiceRequestEntity(
            CarServiceRequest request,
            CarToServiceEntity car,
            CustomerEntity customer
    ) {
        OffsetDateTime when = OffsetDateTime.of(2027, 1, 10, 10, 2, 10, 0, ZoneOffset.UTC);
        return CarServiceRequestEntity.builder()
                .carServiceRequestNumber(generateCarServiceRequestNumber(when))
                .receivedDateTime(when)
                .customerComment(request.getCustomerComment())
                .customer(customer)
                .car(car)
                .build();
    }

    private String generateCarServiceRequestNumber(OffsetDateTime when) {
        return "%s.%s.%s-%s.%s.%s.%s".formatted(
                when.getYear(),
                when.getMonth().ordinal(),
                when.getDayOfMonth(),
                when.getHour(),
                when.getMinute(),
                when.getSecond(),
                randomInt(10, 100)
        );
    }

    @SuppressWarnings("SameParameterValue")
    private int randomInt(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public CarServiceRequestEntity findAnyActiveServiceRequest(String carVin) {
        Set<CarServiceRequestEntity> serviceRequests = carServiceRequestDAO.findActiveServiceRequestsByCarVin(carVin);
        if (serviceRequests.size() != 1) {
            throw new RuntimeException(
                    "There should be only one active service request at a time, car vin: [%s]".formatted(carVin));
        }
        return serviceRequests.stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Could not find any service requests, car vin: [%s]".formatted(carVin)));
    }
}
