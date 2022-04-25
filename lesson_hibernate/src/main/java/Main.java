import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static void main(String[] args) {
        //jpa - java persistence api
        //spring data - работает с hibernate через jpa
        //HSQL - hibernate sql


        //СОЗДАТЬ НОУТБУКИ И СОХРАНИТЬ ИХ В БАЗЕ
        //create();

        //ИЗВЛЕЧЬ НОУТБУК ПО ID
//        selectById(1);
//        selectById(2);


       //извлечь ноутбуки с названием acer1 и ценой < 150
        //selectByNamePrice("acer1", 150);

        //Увеличить стоимость ноутбука с Id 2 на 100 руб
        //updatePrice(2);

        //Удалить по id
        deleteByid(3);
        sessionFactory.close();

    }
    static void deleteByid(int id){
        Session session = sessionFactory.openSession();
        Laptop laptop = session.find(Laptop.class, id);
        session.getTransaction().begin();
        session.delete(laptop);
        session.getTransaction().commit();
        session.close();
    }

    static void updatePrice(int id){
        Session session = sessionFactory.openSession();
        Laptop laptop = session.find(Laptop.class, id);
        laptop.setPrice(laptop.getPrice()+100);
        session.getTransaction().begin();
        session.save(laptop);
        session.getTransaction().commit();
        session.close();
    }
    static void selectByNamePrice(String name, int price){
        Session session = sessionFactory.openSession();

        Query<Laptop> query = session.createQuery("select l from Laptop l where l.name = :name and l.price < :price", Laptop.class);
        query.setParameter("name", name);
        query.setParameter("price", price);
        List<Laptop> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        session.close();
        //jpa - java persistence api
        //spring data - работает с hibernate через jpa
    }



    static void selectById(int id){
        Session session = sessionFactory.openSession();
        Laptop laptop = session.find(Laptop.class, id);
        System.out.println(laptop);
        session.close();

    }

    static void create(){
        Laptop laptop1 = new Laptop("acer1", 100, 4);
        Laptop laptop2 = new Laptop("acer2", 120, 5);
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(laptop1);
        session.save(laptop2);
        session.getTransaction().commit();
        session.close();
    }
}
