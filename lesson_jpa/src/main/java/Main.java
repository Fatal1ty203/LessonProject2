import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_jpa");
    public static void main(String[] args) {


        //JPSQL - java persistence query language (jpa sql)



        //СОЗДАТЬ НОУТБУКИ И СОХРАНИТЬ ИХ В БАЗЕ
        //create();

        //ИЗВЛЕЧЬ НОУТБУК ПО ID
//        selectById(1);
//        selectById(2);


//       извлечь ноутбуки с названием acer1 и ценой < 150
//        selectByNamePrice("acer1", 150);

        //Увеличить стоимость ноутбука с Id 2 на 100 руб
        //updatePrice(2);

        //Удалить по id
//        deleteByid(3);
//        sessionFactory.close();

        //СОСТОЯНИЯ ОБЪЕКТА
        //new - новый объект, который еще не сохраненв базе (hibernate им еще не управляет)
        //managed - управляемый объект (объект становится управляемым после сохранения)
        //detached - открепленный объект (это объект, который ранее был в статусе managed, но он потерял связь с hibernate, напрмер, по причине закрытия сессии)
        //deleted - удаленный объект (после метода remove)

        //Laptop laptop1 = new Laptop("acer1", 100, 4);
        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(laptop1); //статус объекта стал managed
//        em.getTransaction().commit();
//
//        //управление объектом позволяет менять его данные и обновлять их
//        laptop1.setPrice(-1);
//        em.getTransaction().begin();
//        em.persist(laptop1); //hibernate не создаст второй объект Laptop, так как он понимает, что этот объект уже есть в базе и его надо просто обновить
//        em.getTransaction().commit();

        //что если я хочу изменить параметры объекта в базе (с состоянием managed), не загружая его из базы
        Laptop newLaptop = new Laptop(6, "acer1", 100, 4);
        em.getTransaction().begin();
        //для обвноления объекта передаем в метод объект с указанным id и статусом NEW,
        // метод возвращает тот же объект, но уже в статусе managed
        newLaptop = em.merge(newLaptop);
        em.getTransaction().commit();

        //проверка, что статус объекта Managed (если нет, то обновить через persist не выйдет)
        newLaptop.setPrice(1000);
        em.getTransaction().begin();
        em.persist(newLaptop);
        em.getTransaction().commit();


        //Удаляем объект, перевода его в статус deleted
//        em.getTransaction().begin();
//        em.remove(newLaptop);
//        em.getTransaction().commit();






    }
    static void deleteByid(int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Laptop laptop = em.find(Laptop.class, id);
        em.getTransaction().begin();
        em.remove(laptop);
        em.getTransaction().commit();
        em.close();
    }

    static void updatePrice(int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Laptop laptop = em.find(Laptop.class, id);
        laptop.setPrice(laptop.getPrice()+100);
        em.getTransaction().begin();
        em.persist(laptop);
        em.getTransaction().commit();
        em.close();
    }
    static void selectByNamePrice(String name, int price){
        EntityManager em = entityManagerFactory.createEntityManager();

        TypedQuery<Laptop> query =
                em.createQuery("select l from Laptop l where l.name = :name and l.price < :price", Laptop.class);
        query.setParameter("name", name);
        query.setParameter("price", price);
        List<Laptop> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        em.close();
        //jpa - java persistence api
        //spring data - работает с hibernate через jpa
    }



    static void selectById(int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Laptop laptop = em.find(Laptop.class, id);
        System.out.println(laptop);
        em.close();

    }

    static void create(){
        Laptop laptop1 = new Laptop("acer1", 100, 4);
        Laptop laptop2 = new Laptop("acer2", 120, 5);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(laptop1);
        em.persist(laptop2);
        em.getTransaction().commit();
        em.close();
    }
}
