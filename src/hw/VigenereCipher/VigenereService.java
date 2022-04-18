package hw.VigenereCipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class VigenereService {
    private String incomingMessage;
    private String cipher;

    public VigenereService(String incomingMessage, String cipher) {
        this.incomingMessage = incomingMessage;
        this.cipher = cipher;
    }

    private List<Integer> ciphWord(String cipher){
        String[] chip = new Alphabet().getAlphabet();
        String[] ch = cipher.split("");
        List<Integer> index = new ArrayList<>();
        for (int i =0; i <= ch.length; i++){
            for (int j = 0; j <= chip.length; j++){
                if (ch[i].equals(chip[j])){
                    index.add(j);
                }
            }
        }
        return index;
    }



    private void ciphering(List<String> str, List<Integer> ciphWord){
        boolean isExit = false;
        List<String> stringList = new LinkedList<>();
        while (!isExit){
            for (int i = 0; i <= ciphWord.size(); ){
                for (int j = 0; j <= str.size(); j++){
                    stringList.add(search(str.get(j), ciphWord.get(i)));
                    if (i >= ciphWord.size() -1){
                        i =0;
                    }else {
                        i++;
                    }
                }
            }
        }
    }

//    ArrayList<String> collect = Arrays.stream(lines.forEach(x->x.split(" "))
//            .map(x -> Arrays.asList(x.split("\\.")))
//            .collect(ArrayList::new, List::addAll, List::addAll);
//        System.out.println(collect);

//

//    for (int i = 0; i <= s.size() && !is ; ) {
//        for (int j = 0; j <= t.size() ; j++) {
//            System.out.println("i= " + s.get(i) + ", J = " + j);
//            if (j + s.get(i) >= t.size()) {
//                cip = (j + s.get(i) - t.size());
//                is = true;
//            } else {
//                cip = j + s.get(i);
//            }
//            System.out.println(t.get(cip));
//            if (i >= s.size() - 1) {
//                i = 0;
//            } else {
//                i++;
//            }
//        }
//    }

    public static List<String> dosome(List<String> list){
        return list.stream().flatMap(s -> s.chars().mapToObj(c -> Character.toString(c))).collect(Collectors.toList());
    }

    private String search(String element, Integer encrypted){
        String[] ch = new Alphabet().getAlphabet();
        int cip = 0;
        for (int i = 0; i <= ch.length; i++){
            if (element.equals(ch[i])){
                cip = i+encrypted;
            }else {
                return element;
            }
        }
        if (cip > ch.length){
            cip = cip - ch.length;
        }
        return ch[cip];
    }

}
