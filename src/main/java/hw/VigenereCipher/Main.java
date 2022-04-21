package hw.VigenereCipher;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> s = new LinkedList<>();
        List<String> t = new LinkedList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        t.add("Зая привет");
        int cip = 0;
        boolean is = false;

//
//            for (int i = 0; i <= s.size() && !is ; ) {
//                for (int j = 0; j <= t.size() ; j++) {
//                    System.out.println("i= " + s.get(i) + ", J = " + j);
//                    if (j + s.get(i) >= t.size()) {
//                        cip = (j + s.get(i) - t.size());
//                        is = true;
//                    } else {
//                        cip = j + s.get(i);
//                    }
//                    System.out.println(t.get(cip));
//                    if (i >= s.size() - 1) {
//                        i = 0;
//                    } else {
//                        i++;
//                    }
//                }
//            }

        VigenereService vs = new VigenereService();
        vs.ciphering1(vs.dosome(t),s).forEach(System.out::println);
        }
    }


