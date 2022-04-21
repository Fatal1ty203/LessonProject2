package hw.homework_data;


import java.io.*;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Service {
    private String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject2\\src\\hw\\homework_data\\residents.txt";

    public List<Presidents> readToFile(){
        List<Presidents> presidents = new ArrayList<>();
        try(BufferedReader bufer = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = bufer.readLine()) != null){
                String[] arr = line.split(":");
                String[] arr2 = arr[1].split(" - ");
                Date date = new SimpleDateFormat("dd.MM.yyyy").parse(arr2[0]);
                Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse(arr2[1]);
                SimpleDateFormat sm = new SimpleDateFormat("dd.MMMM.yyyy");
                String d1 = sm.format(date);
                String d2 = sm.format(date1);
                presidents.add(new Presidents(arr[0],date,date1));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return presidents;
    }

    public Presidents getPresident(Date date){
        List<Presidents> lsp = readToFile();
        Presidents ps = null;
        for (Presidents president : lsp){
            if (date.after(president.getStartOfTern()) && date.before(president.getEndOfTern())
                    || date.equals(president.getStartOfTern()) || date.equals(president.getEndOfTern()) ){
                ps = president;
            }
        }
        return ps;
    }

    public Presidents getPresident(List<Presidents> presidents, String name){
        Presidents president = null;
        for (Presidents presidents1 : presidents){
            if (presidents1.getName().equalsIgnoreCase(name)){
                president = presidents1;
            }
        }
        return president;
    }

    public Presidents addPresident() throws ParseException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите имя и фамилию президента: ");
        String name = scn.nextLine();
        System.out.print("Введите дату начала правления президента(формате - 23.12.1999): ");
        String date1 = scn.next();
        System.out.print("Введите дату окончания правления президента(формате - 23.12.1999): ");
        String date2 = scn.next();

        Date date =  new SimpleDateFormat("dd.MM.yyyy").parse(date1);

        Date dt = new SimpleDateFormat("dd.MM.yyyy").parse(date2);

        return new Presidents(name,date,dt);
    }

    public void save(List<Presidents> presidents){
        try(PrintWriter pw = new PrintWriter(path)) {
            for (Presidents president : presidents){
                pw.println(president.getName() + " : " + president.getSd1() + " - " + president.getSd2());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
