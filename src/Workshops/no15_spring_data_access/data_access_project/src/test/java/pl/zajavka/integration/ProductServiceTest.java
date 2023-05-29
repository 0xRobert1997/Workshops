package pl.zajavka.integration;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import pl.zajavka.Configuration.ApplicationConfiguration;
import pl.zajavka.business.*;
import pl.zajavka.domain.Opinion;
import pl.zajavka.domain.Product;
import pl.zajavka.domain.Purchase;

import java.util.List;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceTest {

    private ReloadDataService reloadDataService;
    private PurchaseService purchaseService;
    private OpinionService opinionService;
    private ProductService productService;
    private ProductRemovalService productRemovalService;

    @BeforeEach
    public void setUp() {
        Assertions.assertNotNull(reloadDataService);
        Assertions.assertNotNull(purchaseService);
        Assertions.assertNotNull(opinionService);
        Assertions.assertNotNull(productService);
        reloadDataService.reloadData();
    }

    @Test
    @DisplayName("Polecenie 10")
    void thatProductIsWiped() {
        //given
        final var productCode = "68084-618";
        Product before = productService.find(productCode);
        List<Opinion> opinionsBefore = opinionService.findAllByProductCode(productCode);
        List<Purchase> purchasesBefore = purchaseService.findAllByProductCode(productCode);

        Assertions.assertEquals(3, opinionsBefore.size());
        Assertions.assertEquals(4, purchasesBefore.size());
        //when
        productRemovalService.removeCompletely(productCode);
        //then
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> productService.find(productCode));
        Assertions.assertEquals("Product with code: [%s] doesn't exist".formatted(productCode), exception.getMessage());

        Assertions.assertTrue(opinionService.findAllByProductCode(productCode).isEmpty());
        Assertions.assertTrue(purchaseService.findAllByProductCode(productCode).isEmpty());
    }
}
