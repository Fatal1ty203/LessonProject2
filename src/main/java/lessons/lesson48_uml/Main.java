package lessons.lesson48_uml;

import java.util.ArrayList;

public class Main {
//+ public
//- private
//# protected
//~ default

}

class Service{
        public void startProgram(){
                Book book = new Book();
                Library library = new Library();
                library.list.add(book);
        }
}


class Book{

}

class Library{
        ArrayList<Book> list = new ArrayList<>(); //агрегация
}

class Heart{

}

class Organ{

}

class Human{
        Heart heart; //композиция
        ArrayList<Organ> organList; //композиция
}
