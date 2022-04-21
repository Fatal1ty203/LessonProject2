package lessons.lesson36_1_lyamba;

public class Main {
    public static void main(String[] args) {
        //Создать класс Converter с методом
        //public int convert(String val)
        //
        //Создать на его основе несколько анонимных классов и изменить реализацию метода
        Convert convertAnonim = new Convert(){
            @Override
            public int convert(String val) {
                String replace = val.replaceAll("\\D", ""); //это регулярное выражение, \\D означает любой символ, кроме числа

                return Integer.parseInt(replace);
            }
        };

        System.out.println(convertAnonim.convert("3d4"));




        //- Создать функциональный интерфейс MyConsumer с методом
        //double apply (double val)
        //Создать два анонимных класса на основе этого метода
        //1. Метод apply будет вычислять доход работника за вычетом налогов
        //2. Метод apply будет извлекать квадратный корень из числа val

//        MyConsumer myConsumer = new MyConsumer() {
//            @Override
//            public double apply(double val) {
//                return val*0.87;
//            }
//        };
//
//        MyConsumer myConsumer2 = new MyConsumer() {
//            @Override
//            public double apply(double val) {
//                return Math.sqrt(val);
//            }
//        };
//
//        System.out.println(myConsumer.apply(100));
//        System.out.println(myConsumer2.apply(9));

        //Сделать созданные выше два объекта через лямбда выражение
        //Лямбда выражение в подробном виде:
        MyConsumer myConsumer = (double val)->{
            return val*0.87;
        };

        //Лямбда выражение в сокращенной форме
        MyConsumer myConsumer2 = val -> val*0.87;
        System.out.println(myConsumer2.apply(1000));

        //- Написать интерфейс, который будет содержать void метод print(val)
        //Реализовать анонимный класс на основе лямбды, который будет принимать значение и просто выводить на консоль
        //Здесь уже должна быть конечная операция, так как метод void и return делать он не может

        //подробная форма
        Printer printer = (text)->{
            System.out.println(text);
        };
        //сокращенная форма (поскольку метод void, внутри лямбды должна быть финальная операция)
        Printer printer2 = (text)-> System.out.println(text);
//        Printer printer2 = System.out::println; //вариант через ссылку на метод
        printer2.print("hello");


        //- Лямда выражения можно передавать в качестве параметров
        //Создать интерфейс MyExecutor с методом
        //void execute(String text);
        //
        //Написать класс Worker, который содержит метод
        //public void getWork(MyExecutor executor, String text)
        //
        //Данный метод имитирует занятость рабочего, типа мы ему можем давать разные задания
        //Чтобы один метод мог выполнять разные задания, каждый вид задания мы можем передавать через лямбда выражения
        //1. Дать рабочему задание перетаскать мешки с цементом
        //2. Дать рабочему задание перевезти мебель из одной квартиры в другую

        Worker worker = new Worker("Vasiliy");

//
//        MyExecutor myExecutor = new MyExecutor() {
//            @Override
//            public void execute(String text) {
//                System.out.println(text);
//            }
//        };

        MyExecutor myExecutor1 = System.out::println;
        worker.getWork(myExecutor1, "Перетаскивает вещи");
        //Еще более короткий вариант:
        //worker.getWork((text)-> System.out.println(text), "Перетаскивает вещи");
        worker.getWork(System.out::println, "Перетаскивает вещи");

        //второе задание: перевезти мебель, а именно вывести список мебели, которую ему нужно перевезти
        MyExecutor myExecutor = (text)->{
            System.out.println(text);
            System.out.println("Перевезти диван");
            System.out.println("Перевезти кровать");
        };

        worker.getWork(myExecutor, "Перевезти мебель");
    }


}
