package code;

import org.junit.jupiter.api.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before ALL");
    }

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
        System.out.println("Before each!");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("After ALL");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each!");
    }


    @Test
    @DisplayName("Testing method wich tests adding behaviour")
    void add() {
        //given
        int left = 5;
        int right = 7;
        Integer expected = 12;

        //when
        Integer result = Calculator.add(left, right);

        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    void subtract() {
        //given
        int left = 5;
        int right = 7;
        Integer expected = -2;

        //when
        Integer result = Calculator.subtract(left, right);

        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    void multiply() {
        //given
        int left = 5;
        int right = 7;
        Integer expected = 35;

        //when
        Integer result = Calculator.multiply(left, right);

        //then
        Assertions.assertEquals(expected, result);
    }
    @Test
    void divide() {
        //given
        int left = 5;
        int right = 7;
        Integer expected = 0;

        //when
        Integer result = Calculator.divide(left, right);

        //then
        Assertions.assertEquals(expected, result);
    }
}