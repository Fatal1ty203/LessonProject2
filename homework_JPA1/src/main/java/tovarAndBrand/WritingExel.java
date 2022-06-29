package tovarAndBrand;


import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Workbook --> Sheet --> Rows --> Cells
public class WritingExel {
    static SXSSFWorkbook workbook = new SXSSFWorkbook(); // сначала создаем книгу
    static SXSSFSheet sheet = workbook.createSheet("Emp info"); // на основе этой книге создаем лист и присваиваем ему имя
    static int rowCount =0;
    public static void addFirst(String id, String price, String tovarName, String brandName, String country){
        Object empData[][] = { {"ID", "price", "Tovar name", "Brand name", "Country"},
                                {id,price,tovarName,brandName,country}
        };

        int rows = empData.length;
        int cols = empData[0].length;

        for (int i = 0; i < rows; i++ ){
            SXSSFRow row = sheet.createRow(rowCount++);
            for (int j = 0; j <cols; j ++){
                SXSSFCell cell = row.createCell(j);
                Object value = empData[i][j];
                cell.setCellValue((String) value);

            }
        }
        System.out.println(Arrays.stream(empData));
    }

    public static void add(String id, String price, String tovarName, String brandName, String country){
        List<String> list = new ArrayList<>();
        list.add(id);
        list.add(price);
        list.add(tovarName);
        list.add(brandName);
        list.add(country);
        SXSSFRow row = sheet.createRow(rowCount++);
        for (int i = 0; i < list.size(); i++){
            SXSSFCell cell = row.createCell(i);
            cell.setCellValue(list.get(i));
        }
    }

    public static void saveBook() throws IOException {
        String filePath = "homework_JPA1/src/main/java/tovarAndBrand/employee.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }
}
