package lessons.lesson35_junit_test.ex2_student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StudentTest {
    Student student = new Student(); //данный объект будет создаваться перед началом каждого теста


    @Test
    void testAdd_regular_addition() {

        Subject expectedSubject = new Subject("history", 5);
        int size = student.size();
        student.add(expectedSubject);
        //проверяем, что после добавления размер списка стал на 1 больше
        Assertions.assertEquals(size+1, student.size());
        //проверяем, что в список добавился предмет, который мы добавляли, а не что-то другое
        Subject actualSubject = student.get(student.size() - 1);
        Assertions.assertEquals(expectedSubject, actualSubject);
    }


    @Test
    void testAdd_SubjectIsNullException_if_subject_is_null() {
        int size = student.size();
        //проверяем, что в метод add выбросил исключение
        Assertions.assertThrows(SubjectIsNullException.class,()-> student.add(null));
        //проверяем, что после добавления размер списка стал не изменился (то есть не добавили null)
        Assertions.assertEquals(size, student.size());


    }

    @Test
    void testAdd_SubjectNameIsNullException() {
        int size = student.size();
        //проверяем, что в метод add выбросил исключение
        Assertions.assertThrows(SubjectNameIsNullException.class,()-> student.add(new Subject(null, 5)));
        //проверяем, что после добавления размер списка стал не изменился (то есть не добавили null)
        Assertions.assertEquals(size, student.size());


    }


    //Провестировать успешное получение знчения, а также выход за границы списка (что вылезет ошибка)
    @Test
    void testGetRegular() {
        Subject subject = new Subject("Fizra)", 5);
        student.add(subject);
        Assertions.assertEquals(subject,student.get(0));
    }

    @Test
    void testGet_SubjectIndexOutOfBoundsException(){
        Subject subject = new Subject("Matan", 4);
        int size = student.size();
        student.add(subject);
        Assertions.assertEquals(size+1,student.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> student.get(2));
    }

    @Test
    void testGetAverageMark_returnZeroIfEmptyList() {
        Assertions.assertEquals(0, student.getAverageMark());

    }

    @Test
    void testGetAverageMark_ifListNotEmpty() {
        student.add(new Subject("math", 5));
        student.add(new Subject("history", 4));
        Assertions.assertEquals(4.5, student.getAverageMark());

    }

}