package tovarAndBrand;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static EntityManager em = Persistence
            .createEntityManagerFactory("my_homeworkJPA")
            .createEntityManager();

    static String str1 = "select t.id, t.name as tovar_name, t.price, b.name, b.country from brand b join tovar t on b.id = t.brand_id";
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
//        Brand brand1 = new Brand("brand1", "Germany");
//        Brand brand2 = new Brand("brand1", "Italy");
//        Brand brand3 = new Brand("brand3", "China");
//
//        Tovar tovar1 = new Tovar("tovar1", 100);
//        Tovar tovar2 = new Tovar("tovar2", 1000);
//        Tovar tovar3 = new Tovar("tovar3", 50);
//        Tovar tovar4 = new Tovar("tovar4", 500);
//        Tovar tovar5 = new Tovar("tovar5", 1500);
//        Tovar tovar6 = new Tovar("tovar6", 5100);
//
//        tovar1.setBrand(brand1);
//        tovar2.setBrand(brand1);
//        tovar3.setBrand(brand1);
//        tovar4.setBrand(brand2);
//        tovar5.setBrand(brand3);
//        tovar6.setBrand(brand2);
//
//        em.getTransaction().begin();
//        em.persist(tovar1);
//        em.persist(tovar2);
//        em.persist(tovar3);
//        em.persist(tovar4);
//        em.persist(tovar5);
//        em.persist(tovar6);
//        em.getTransaction().commit();

//        selectAll();
//        WritingExel.saveBook();

//        selectGerOrItal();
        deleteChina();

    }

    static void selectAll(){
        List<Object[]> resultList = em.createNativeQuery(str1).getResultList();
        sout(resultList);
        saveInExel(resultList);
    }

    static void selectGermany(){
        String german = " where country = 'Germany'";
        List<Object[]> resultList = em.createNativeQuery(str1 + german).getResultList();
        sout(resultList);
    }

    static void selectGerAndPrice(){
        String gerAndPrice = " where country = 'Germany' and price > 1000";
        List<Object[]> resultList = em.createNativeQuery(str1 + gerAndPrice).getResultList();
        sout(resultList);
    }

    static void selectGerOrItal(){
        String gerAndItal = " where country = 'Germany' OR country = 'Italy'";
        List<Object[]> result = em.createNativeQuery(str1+gerAndItal).getResultList();
        sout(result);
    }

    static void deleteChina(){
        List<Tovar> resultList =
                em.createQuery("select t from Tovar t where brand_id = (select id from Brand where country = 'China')", Tovar.class)
                        .getResultList();
        em.getTransaction().begin();
        resultList.forEach(tovar ->em.remove(tovar));
        em.getTransaction().commit();
    }

    static void sout(List<Object[]> result){
        for (Object[] objects : result){
            for (Object obj : objects){
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }

    static void saveInExel(List<Object[]> result){
        List<String> list = new LinkedList<>();
        for (Object[] objects : result){
            for (Object obj : objects){
                list.add(String.valueOf(obj));
            }
        }
        int count = 0;
        for (int i = 0; i < list.size()/5;){
            if (count < 5) {
                WritingExel.addFirst(list.get(count++), list.get(count++), list.get(count++), list.get(count++),list.get(count++));
            }else {
                WritingExel.add(list.get(count++),list.get(count++),list.get(count++),list.get(count++),list.get(count++));
            }
            i++;
        }

    }
}
