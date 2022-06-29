import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static void main(String[] args) {


//        create();

//        select();

//        selectCal(9000.0);

//        updateCal("Борщь", 5024.7);

//        selectVega();

//        totalCalories("Второе");

//        allCalories();
        allCaloriesSQL();

    }

    static void create(){
        Dish dish = new Dish("Борщь", "Суп", false, 99999.9);
        Dish dish1 = new Dish("Цезарь", "Салат", true, 50.3);
        Dish dish2 = new Dish("Шашлык", "Второе", false, 9700.6);
        Dish dish3 = new Dish("Голубцы", "Второе", false, 5000.8);
        Dish dish4 = new Dish("Коул-Слоу", "Салат", true, 20.1);
        Dish dish5 = new Dish("Картошка", "Гарнир", true, 1.8);
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(dish);
        session.save(dish1);
        session.save(dish2);
        session.save(dish3);
        session.save(dish4);
        session.save(dish5);
        session.getTransaction().commit();
        sessionFactory.close();
    }
    static void select(){
        Session session = sessionFactory.openSession();
        List<Dish> selectAll = session.createQuery("select a from Dish a", Dish.class).getResultList();
        selectAll.forEach(System.out::println);
    }
    static void selectCal(double cal){
        Session session = sessionFactory.openSession();
        Query<Dish> query = session.createQuery("select a from Dish a where a.calories < :cal", Dish.class);
        query.setParameter("cal",cal);
        query.getResultList().forEach(System.out::println);
    }
    static void updateCal(String name, double cal){
        Session session = sessionFactory.openSession();
        Query<Dish> query = session.createQuery("select a from Dish a where a.name = :name", Dish.class);
        Dish dish = query.setParameter("name", name).getSingleResult();
        dish.setCalories(cal);
        session.getTransaction().begin();
        session.save(dish);

        session.getTransaction().commit();
        sessionFactory.close();
    }

    static void deleteForName(String name){
        Session session = sessionFactory.openSession();
        Dish dish = session.createQuery("select a from Dish a where a.name = :name", Dish.class)
                .setParameter("name", name)
                .getSingleResult();
        session.getTransaction().begin();
        session.delete(dish);
        session.getTransaction().commit();
        sessionFactory.close();
    }

    static void selectVega(){
        sessionFactory.openSession()
                .createQuery("select a from Dish a where a.vega = :vega", Dish.class)
                .setParameter("vega",true)
                .getResultList()
                .forEach(System.out::println);
        sessionFactory.close();
    }

    static void totalCalories(String type){
        System.out.println(sessionFactory.openSession()
                .createQuery("select a from Dish a where a.category = :category", Dish.class)
                .setParameter("category", type)
                .stream()
                .mapToDouble(x -> x.calories)
                .sum());
    }

    static void allCalories(){
        Map<String, Double> map = sessionFactory.openSession()
                .createQuery("select a from Dish a ", Dish.class)
                .getResultStream()
                .collect(Collectors.toMap(val -> val.category, val2 -> val2.calories, Double::sum));
        map.forEach((x,y) -> System.out.println(x +" " + y));
    }

    static void allCaloriesSQL(){
        List<Object[]> resultList = sessionFactory.openSession().createQuery("select category, SUM(calories) " +
                "from Dish group by category").getResultList();
        for (Object[] objects : resultList){
            for (Object obj : objects){
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }
}
