package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() throws ArrayIndexOutOfBoundsException{
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, 1),
                () -> Assertions.assertEquals(1, 2),
                () -> Assertions.assertEquals(1, 2)
        );

    }

}