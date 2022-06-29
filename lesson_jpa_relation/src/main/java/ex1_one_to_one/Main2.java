package ex1_one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Person person = entityManager.createQuery("select p from Person p where p.name = 'ivan123'", Person.class).getResultList().get(0);
        person.getPassport().setSeria(9);
        entityManager.getTransaction().begin();;
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }
}
