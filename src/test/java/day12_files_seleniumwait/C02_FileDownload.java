package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void downloadTest() {
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
         driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        // C:\Users\Anduril\Downloads\b10 all test cases, code.docx
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // 2. yol
        String userHome = System.getProperty("user.home");
        String ortakYol = "\\Downloads\\b10 all test cases, code.docx";
        String dynamicPath = userHome + ortakYol;
        boolean isExist = Files.exists(Paths.get(dynamicPath));
        Assert.assertTrue(isExist);

    }

    @Test
    public void downloadDynamicTest() {


        String userHome = System.getProperty("user.home");
        String ortakYol = "\\Downloads\\b10 all test cases, code.docx";
        String dynamicPath = userHome + ortakYol;
        Files.delete(Paths.get(dynamicPath));   //Dosya varsa siler ki tekrar çalıştıracağımızda hata olmasın.

        boolean isExist = Files.exists(Paths.get(dynamicPath));
        Assert.assertTrue(isExist);



        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();


        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        // C:\Users\Anduril\Downloads\b10 all test cases, code.docx
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}
