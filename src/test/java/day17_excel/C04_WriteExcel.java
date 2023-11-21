package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void writeExcel() throws IOException {

        String path = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz

        Sheet sheet = workbook.getSheet("customer_info");
        Row row = sheet.getRow(0);
        Cell cell3 = row.createCell(2); //3. sütuna ekleyeceğiz diye index no 2 girdik
        cell3.setCellValue("STATUS");  //1-createCell 2-setCellValue

        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz
        sheet.getRow(1).createCell(2).setCellValue("valid");
        sheet.getRow(2).createCell(2).setCellValue("valid");
        sheet.getRow(3).createCell(2).setCellValue("invalid");


        // Yazarken çıkmak için fos objesi oluşturup write yapmak lazım.
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fis.close();
        fos.close();

    }



}
