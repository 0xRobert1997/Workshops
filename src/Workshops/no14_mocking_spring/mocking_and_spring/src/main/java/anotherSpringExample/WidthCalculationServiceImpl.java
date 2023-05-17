package anotherSpringExample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class WidthCalculationServiceImpl implements WidthCalculationService{
    @Override
    public BigDecimal calculate(InputData inputData) {
        return new BigDecimal(inputData.getWidth());
    }
}
