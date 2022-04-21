package lessons.lesson35_junit_test.ex1_calculator;

import org.junit.jupiter.api.*;

class CalculatorTest {

    Calculator calculator = new Calculator();


    @BeforeEach
    void setUp() {
        System.out.println("Срабатывает много раз перед началом каждого теста");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Срабатывает много раз после окончания каждого теста");
    }

    @Test
    void testSum_regural_sum() {
        int a = 2;
        int b = 3;
        int expected = a+b; //ожидаемые результат, который должен вернуть метод
        int actual = calculator.sum(a, b); //фактический результат (может не совпадать с ожидаемым, если метод работает неправильно)
        //сравниваем результаты:
        Assertions.assertEquals(expected, actual);


    }

    @Test
    void testDivide_regular_division() {
        double a = 8;
        double b = 2;
        double expected = a/b;
        double actual = calculator.divide(a,b);
        Assertions.assertEquals(expected,actual, .00001); //сравниваем с погрешностью 0.00001
    }

    //тест на то, что при деление на ноль будет выброшено исключение
    @Test
    void testDivide_expectExceptionWithDevideByZero() {
        double a = 8;
        double b = 0;
        //Первый параметр - ожидаемое исключение
        //Второй параметр - вызов нашего метода, который должен это исключение выбросить
        Assertions.assertThrows(ArithmeticException.class, ()-> calculator.divide(a,b));
    }
}