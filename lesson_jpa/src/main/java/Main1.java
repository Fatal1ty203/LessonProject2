

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Laptop> personCriteria = cb.createQuery(Laptop.class);
        Root<Laptop> personRoot = personCriteria.from(Laptop.class);
        personCriteria.select(personRoot);
        em.createQuery(personCriteria)
                .getResultList()
                .forEach(System.out::println);
    }
}
