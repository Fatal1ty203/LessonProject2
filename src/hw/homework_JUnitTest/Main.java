package hw.homework_JUnitTest;

public class Main {
    public static void main(String[] args) {
        CalculatorTest calculator = new CalculatorTest();
        //далее с помощью рефлексии нужно найти в данном объекте все методы, помеченные аннотацией @MyBeforeEach и
        // @MyTest и запустить сначала методы с аннотацией MyBeforeEach, а потом MyTest
    }
}
