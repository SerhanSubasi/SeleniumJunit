package day15_screenshot_extentreport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test01() {
        //techproeducation'a gidiniz
        driver.get("https://techproeducation.com");
        //screenshot alınız
        screenShot();
    }

    @Test
    public void webelementScreenShot() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();
        //ekran resmini alalım
        screenShot();
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\"+date+"webElementSS.png";
        Files.write(Paths.get(dosyaYolu),sonucYazisi.getScreenshotAs(OutputType.BYTES));
    }

    /*
    Bir webelementin ekran görüntüsü nasıl alınır?
    Selenium 4 ile bilrikte artık bir elementin ekran görünütüsü elemente .getScreenshotAs yaparak alabiliyoruz.
    Geri kalanı aynı screenshot olayı.
     */
    @Test
    public void webelementScreenShot2() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();
        //ekran resmini alalım
        screenShot();
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenShotOfWebElement(sonucYazisi);
    }
}
