package code;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    @Disabled("Explanation why this test is disabled xd")
    void assertionsTest() {
        Assertions.assertEquals(1, 1, createMessage(1));
        Assertions.assertEquals("test1", "test2", () -> "custom message");

        Assertions.assertAll(
                () -> Assertions.assertEquals("test1", "test2", () -> "custom message1"),
                () -> Assertions.assertEquals("test1", "test2", () -> "custom message2")
                );

    }

    private String createMessage(int param) {
        System.out.println("message creation: " + param);
        return "Failure message " + param;
    }

    @ParameterizedTest
    @MethodSource(value = "testData")
    void testCalculator(int[] testData) {
        //given, when ,then
        Assertions.assertEquals((Integer) testData[0], (Integer) Calculator.add(testData[1], testData[2]));
    }
    public static int[][] testData() {
        return new int[][]{
                {5, 2,3},
                {8, 3,5},
                {9, 2,7}};
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