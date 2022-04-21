package lessons.lesson19_nested_classes.ex3_inner_method_class;

public class Main {
    public static void main(String[] args) {
        //Вложенные классы можно создавать даже внутри методов:
    }

    public void test(){
        class Inner{
            int field1;
            String field2;

            public Inner(int field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }
        }

        Inner inner = new Inner(2, "three");

    }
}
