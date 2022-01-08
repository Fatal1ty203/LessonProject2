package lessons.lesson25_binaryTree.ex3_realMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("one", 5);
        map1.put("two", 2);
        map1.put("three", 3);
        map1.put("three", 5);

        System.out.println("Способ вывода 1");
        Set<String> keys = map1.keySet();
        for (String key : keys) {
            System.out.println(key+" "+map1.get(key));
        }
        System.out.println("Способ вывода 2");
        Collection<Integer> values = map1.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        System.out.println("Способ вывода 3");
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }



    }
}
