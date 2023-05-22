package pl.zajavka.mortgage.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.mortgage.fixtures.TestDataFixtures;
import pl.zajavka.mortgage.model.InputData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class InputDataServiceTest {

    @InjectMocks
    InputDataService inputDataService = new InputDataService();

    @Test
    void shouldReadDataCorrectly() {
        //given
        var expected = TestDataFixtures.someInputData()
                .withRepaymentStartDate(LocalDate.of(2020, 1, 1))
                .withMarginPercent(BigDecimal.valueOf(2.2))
                .withOverpaymentProvisionPercent(BigDecimal.valueOf(10))
                .withOverpaymentStartMonth(BigDecimal.valueOf(10))
                .withWiborPercent(BigDecimal.valueOf(6.23))
                .withAmount(BigDecimal.valueOf(571521.99))
                .withMonthsDuration(BigDecimal.valueOf(240))
                .withOverpaymentSchema(new HashMap<>() {{
                    put(15, BigDecimal.valueOf(10000));
                    put(20, BigDecimal.valueOf(10000));
                    put(25, BigDecimal.valueOf(10000));
                    put(30, BigDecimal.valueOf(10000));
                    put(35, BigDecimal.valueOf(10000));
                }});
        //when
        Optional<InputData> read = inputDataService.read();
        InputData result = read.orElseThrow();
        //then
        Assertions.assertEquals(expected, result);

    }


}