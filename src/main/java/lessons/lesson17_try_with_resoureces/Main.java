package lessons.lesson17_try_with_resoureces;

import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\lessons.lesson17_try_with_resoureces\\data.txt";
        writeToFile_try_with_resources(path, List.of("one", "two", "three"));
    }

    public static void writeToFile_try_with_resources(String path, List<String> list) {
        try(PrintWriter pw = new PrintWriter(path)) {
            for (String str : list) {
                pw.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile_simple_try_catch(String path, List<String> list) {


        //Записываем в файл список
        PrintWriter pw=null;
        try {

            pw = new PrintWriter(path);
            for (String str : list) {

                pw.println(str);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(pw!=null) pw.close();
        }
    }
}
