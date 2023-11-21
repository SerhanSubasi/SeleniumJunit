package day17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        //1- Projemize resources package'i altinda bulunan excel dosyamizin yolunu belirtmeliyiz
        String path ="src\\test\\java\\resources\\Capitals.xlsx";

        //2- FileInputStream class'ını kullanarak bir stream oluşturduk ve bu akış ile dosyamızdan gelen datayı Java ortamına aktaracağız.
        FileInputStream fis = new FileInputStream(path);

        //3- fis objemiz üzerinden bir excel dosyasını oluşturduk. Excel dosyasından verileri okuyabilmek için dosyayı Java ortamında açtık.
         Workbook workbook = WorkbookFactory.create(fis); //Sanal Excel dosyası oldu

        //4- Bir Excel (=workbook) dosyasında birden fazla sayfa bulunabilir. Bu nedenle "Sheet1" adlı çalışma sayfasını açmak
        // ve bu sayfadaki datalarla çalışabilmek için bu kodu yazdık.
        Sheet sheet = workbook.getSheet("Sheet1");  //Sheet objesine yükledik.

        //5- Sayfadaki bir row'u index girerek seçtik ve row objesine atadık.
        Row row = sheet.getRow(0);

        //6- Bir cell'i index girerek seçtik ve cell objesine atadık.
        Cell cell = row.getCell(0);

        System.out.println("cell = " + cell);


    }


    @Test
    public void test02() throws IOException {   //Daha basit yöntem

        String path ="src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(0);

    }

}
