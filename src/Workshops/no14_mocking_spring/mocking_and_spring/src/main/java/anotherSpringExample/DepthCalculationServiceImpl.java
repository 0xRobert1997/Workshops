package anotherSpringExample;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepthCalculationServiceImpl implements DepthCalculationService {
    @Override
    public BigDecimal calculate(InputData inputData) {
        return new BigDecimal(inputData.getDepth());
    }
}
