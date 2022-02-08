package lessons.lesson37_stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main4_boxed_mapToObj {
    public static void main(String[] args) {

        //.mapToObj(x->x) //конвертируем IntStream в Stream<IntegeR>
        //.boxed()//конвертируем IntStream в Stream<IntegeR>
        List<Integer> list = new Random()
                .ints(10,2,11)
                //.mapToObj(x->x)
                .boxed()
                .collect(Collectors.toList());


    }
}
