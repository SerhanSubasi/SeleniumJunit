package day17_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        String path ="src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1); //CAPITAL
        System.out.println(cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String Actualcell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String expectedCell = "France";
        Assert.assertEquals(expectedCell,Actualcell);

        //Örnek 3: Kullanılan satır sayısın bulun
        // getPhysicalNumberOfRows(); methodu içinde data olan satırların sayısını verir. Bizlere sayı verdiği için index 1'den başlar.

        int toplamSatır=   workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("Toplam satır sayısı : "+toplamSatır);

        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        int lastIndex = workbook.getSheet("Sheet1").getLastRowNum(); //11 satır varsa 10 verecek çünkü indexler 0'dan başlar.
        System.out.println(lastIndex);

        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}
            Map<String,String> ulkeBaskentleri = new HashMap<>();

        for (int i = 0; i <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println("ulkeBaskentleri = " + ulkeBaskentleri);

    }


}
