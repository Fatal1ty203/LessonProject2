package lessons.lesson20_iterator.ex4_pattern_example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Паттер Iterator позволяет расширять возжный вывод элементов (добавлять разные варианты вывода)
        //Создать две соц сети: instagram and facebook с суперклассом Network.
        //Создать класс Service, позволяющий выводить элементы из соцсетей через разные итераторы
        //Создать два итератора: SimpleItertor - просто выводит всех юзеров
        //AgeIterator - выводит юзеров, чей возраст больше определенного

        Facebook facebook = new Facebook();
        facebook.add(new Profile("name1", 20));;
        facebook.add(new Profile("name2", 17));;
        facebook.add(new Profile("name3", 21));;

        Instagram instagram = new Instagram();
        instagram.add(new Profile("name4", 20));;
        instagram.add(new Profile("name5", 17));;
        instagram.add(new Profile("name6", 21));;


        //Выведем просто всех юзеров из раных сетей
        //вывдем из интсты
        ServiceIterator serviceIterator = new ServiceIterator();
        serviceIterator.setIterator(new SimpleIterator(instagram.profileList));
        System.out.println("Instagram:");
        Iterator<Profile> iterator = serviceIterator.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //вывдем из faceBook
        System.out.println("facebook:");
        serviceIterator.setIterator(new SimpleIterator(facebook.profileList));
        iterator = serviceIterator.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //Вывести только тех юзеров, чей возраст больше 18 из инсты
        System.out.println("Пользователи инсты старше 18 лет");
        serviceIterator.setIterator(new AgeIterator(instagram.profileList, 18));
        iterator = serviceIterator.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}

class AgeIterator implements Iterator<Profile>{

    List<Profile> ageProfileList = new ArrayList<>();
    int profileIndex;
    public AgeIterator(List<Profile> profiles, int age) {
        //копируем в локальный список только юзеров, чей возраст больше age
        for(Profile profile : profiles){
            if(profile.age >= age) {
                ageProfileList.add(profile);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return profileIndex < ageProfileList.size();
    }

    @Override
    public Profile next() {
        return ageProfileList.get(profileIndex++);
    }
}

class SimpleIterator implements Iterator<Profile>{

    List<Profile> profiles ;
    int profileIndex;
    public SimpleIterator(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public boolean hasNext() {
        return profileIndex < profiles.size();
    }

    @Override
    public Profile next() {
        return profiles.get(profileIndex++);
    }
}

class ServiceIterator implements Iterable<Profile>{

    private Iterator<Profile> iterator;



    public void setIterator(Iterator<Profile> iterator) {
        this.iterator = iterator;
    }


    @Override
    public Iterator<Profile> iterator() {
        return iterator;
    }
}

class Network{
    String name;
    List<Profile> profileList = new ArrayList<>();

    public void add(Profile profile){
        profileList.add(profile);
    }

}

class Facebook extends Network{

}

class Instagram extends Network{

}


class Profile{
    String name;
    int age;

    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Profiel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}