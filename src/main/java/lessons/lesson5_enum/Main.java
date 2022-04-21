package lessons.lesson5_enum;

public class Main {
    public static void main(String[] args) {
        Symbol symbol1 = Symbol.X;
        Symbol symbol2 = Symbol.O;
        System.out.println(symbol1);
        System.out.println(Symbol.O);
        System.out.println(Symbol.EMPTY);
        System.out.println(symbol1 == symbol2);
        System.out.println(symbol1 == Symbol.X); //можно сравнивать через ==

        //Сравнение с обычными строчками:
        String s1 = StaticSymbol.X;
        String s2 = StaticSymbol.O;
        System.out.println(s1.equals(s2)); //надо сравнивать через  equals

    }
}

class StaticSymbol{
    public static final String X = "X";
    public static final String O = "O";
}

enum Symbol{
    X, O, EMPTY
}