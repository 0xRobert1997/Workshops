package code.business;

import code.business.management.FileDataPreparationService;
import code.business.management.Keys;
import code.infrastructure.database.entity.CarToBuyEntity;
import code.infrastructure.database.entity.CustomerEntity;
import code.infrastructure.database.entity.InvoiceEntity;
import code.infrastructure.database.entity.SalesmanEntity;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class CarPurchaseService {

    private final FileDataPreparationService fileDataPreparationService;
    private final CustomerService customerService;

    private final CarService carService;
    private final SalesmanService salesmanService;
    public void purchase() {
        var firstTimeData = fileDataPreparationService.prepareFirstTimePurchaseData();
        var nextTimeData = fileDataPreparationService.prepareNextTimePurchaseData();

       List<CustomerEntity> firsTimeCustomers =  firstTimeData.stream()
                .map(this::createFirstTimeToBuyCustomer)
                .toList();
       firsTimeCustomers.forEach(customerService::issueInvoice);

        List<CustomerEntity> nextTimeCustomers =  nextTimeData.stream()
                .map(this::createNextTimeToBuyCustomer)
                .toList();
        nextTimeCustomers.forEach(customerService::issueInvoice);
    }

    private CustomerEntity createFirstTimeToBuyCustomer(Map<String, List<String>> inputData) {
        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        SalesmanEntity salesman = salesmanService.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        InvoiceEntity invoice = buildInvoice(car, salesman);

        return fileDataPreparationService.buildCustomerEntity(inputData.get(Keys.Entity.CUSTOMER.toString()), invoice);

    }

    private CustomerEntity createNextTimeToBuyCustomer(Map<String, List<String>> inputData) {
        CustomerEntity existingCustomer = customerService.findCustomer(inputData.get(Keys.Entity.CUSTOMER.toString()).get(0));
        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        SalesmanEntity salesman = salesmanService.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        InvoiceEntity invoice = buildInvoice(car, salesman);
        existingCustomer.getInvoices().add(invoice);
        return existingCustomer;
    }

    private InvoiceEntity buildInvoice(CarToBuyEntity car, SalesmanEntity salesman) {
        return InvoiceEntity.builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now())
                .car(car)
                .salesman(salesman)
                .build();
    }
}
