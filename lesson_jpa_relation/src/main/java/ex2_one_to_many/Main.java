package ex2_one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = new User("ivan");
        User user2 = new User("petr");
        Account account1 = new Account("login1", "password1");
        Account account2 = new Account("login2", "password1");
        Account account3 = new Account("login3", "password3");

        account1.setUser(user1);
        account2.setUser(user1);
        account3.setUser(user2);

        entityManager.getTransaction().begin();
        entityManager.persist(account1);
        entityManager.persist(account2);
        entityManager.persist(account3);
        entityManager.getTransaction().commit();

    }
}
