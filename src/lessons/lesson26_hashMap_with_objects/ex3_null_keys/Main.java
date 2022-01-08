package lessons.lesson26_hashMap_with_objects.ex3_null_keys;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //null может быть в качестве ключа
        map.put(null, 10);
        //null может быть в качестве значения
        map.put("one", null);

        System.out.println(map.get(null));
        System.out.println(map.get("one"));
    }
}
