package ex3_many_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Изменить максмальную скорость транспортного средства v1 и у владельца o1
        Owner owner = entityManager.createQuery("select o from Owner o where o.name = 'Ivan'", Owner.class).getResultList().get(0);
        Vehicle v1 = owner.getVehicleList().stream().filter(v -> v.getName().equals("v1")).findAny().get();
        v1.setMaxSpeed(v1.getMaxSpeed()+50);

        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.getTransaction().commit();

    }
}
