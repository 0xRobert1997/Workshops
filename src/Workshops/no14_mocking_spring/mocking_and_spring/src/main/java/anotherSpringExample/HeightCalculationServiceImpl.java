package anotherSpringExample;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class HeightCalculationServiceImpl implements HeightCalculationService{
    @Override
    public BigDecimal calculate(InputData inputData) {
        return new BigDecimal(inputData.getHeight());
    }
}
