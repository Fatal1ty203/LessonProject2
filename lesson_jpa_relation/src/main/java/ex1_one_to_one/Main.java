package ex1_one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Person person = new Person("ivan", "ivanov");
        Passport passport = new Passport(1234, 123456, 20);
        passport.setPerson(person); //чтобы внешний ключ появился в БД, надо ему присвоить значение в коде

//        entityManager.getTransaction().begin();
//        //вариант сохранения без каскадного сохранения
////        entityManager.persist(passport);
//        //entityManager.persist(person);
//
//        //вариант сохранения с каскадным сохранением
//        entityManager.persist(passport);
//        entityManager.getTransaction().commit();

        //Добавить person с id 1 автомобиль lada

        //вариант через поиск объекта из базы, чтобы он был в состояни управляемомго
        Car car1 = new Car("lada", 250, 1000);
        car1.setPerson(entityManager.find(Person.class, 1));

        entityManager.getTransaction().begin();
        entityManager.persist(car1); //делаем через merge так как внутри car1 находится неуправляемый объект person
        entityManager.getTransaction().commit();

        //вариант через merge
//        Car car1 = new Car("lada", 250, 1000);
//        car1.setPerson(Owner(1, "ivan123", "ivanov"));
//
//        entityManager.getTransaction().begin();
//        entityManager.merge(car1); //делаем через merge так как внутри car1 находится неуправляемый объект person
//        entityManager.getTransaction().commit();


    }
}
