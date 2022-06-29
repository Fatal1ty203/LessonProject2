package ex3_many_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Owner o1 = new Owner("Ivan", "Ivanov");
        Owner o2 = new Owner("Semen", "Ivanov");

        Vehicle v1 = new Vehicle("v1", 200, 10);
        Vehicle v4 = new Vehicle("v1", 240, 20);
        Vehicle v2 = new Vehicle("v2", 200, 10);
        Vehicle v3 = new Vehicle("v3", 200, 10);


        //сохранение через зависимую сущность: (удачное)
        v1.getOwnerList().add(o1);
        v1.getOwnerList().add(o2);

        v2.getOwnerList().add(o1);
        v3.getOwnerList().add(o2);

        entityManager.getTransaction().begin();
        entityManager.persist(v1);
        entityManager.persist(v2);
        entityManager.persist(v3);
        entityManager.getTransaction().commit();


        //сохранение через главную сущность (неудачно, так как не сохранятся свзи в тертьей таблице)
//        o1.getVehicleList().add(v1);
//        o1.getVehicleList().add(v2);
//
//        o2.getVehicleList().add(v1);
//        o2.getVehicleList().add(v3);
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(o1);
//        entityManager.persist(o2);
//        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
