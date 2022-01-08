package lessons.lesson18_2_modifier.fruit;

public class Shop {
    Fruit f =new Fruit(); //условно говоря в магазине есть фрукт
    public void print(){
        //Выведем ассортимент
        StringBuilder sb = new StringBuilder();
        sb.append(f.name); //ok, public
        sb.append(f.price); //ok, protected доступно в наследнике в любом месте
        sb.append(f.color); //ok, default modifier, Доступен в любом месте в рамках пакета
        //sb.append(f.weight); //error, private modifier

    }

}
