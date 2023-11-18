package day14_exception_screenshoot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_Screenshot extends TestBase {

    /*
    1- Almak istediğimiz ekran görüntüsünü kaydetmek için bir dosya yolu belirleriz.
    2- TakesScreenShot interface'inden bir obje deklare ederek driver'ı bu objeye assign edeceğiz.
    3- Files class'ından write() methodunu kullanarak içine parametre olarak neyi nereye kaydedelim bunu belirtiriz.
        daha sonra da getScreenShotAs() Methodu ile ekran görünüsünü alarak bu görüntüyü kaydetmek için almış olduğumuz dosya yolunu belirtiriz.
     */




    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Sayfanın ekran görüntüsünü alınız.
        String dosyaYolu = "src\\test\\java\\screenShots\\amazon.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));


    }

    @Test
    public void test02() throws IOException {
        // TechProEducation sayfasına gidiniz
        driver.get("https://techproeducation.com");
        // ekran görüntüsünü alınız
        String dosyaYolu = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\techpro.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void test03() throws IOException {
        // Facebook sayfasına gidiniz
        driver.get("https://facebook.com");
        // ekran görüntüsünü alınız
        String dosyaYolu = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\facebook.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
    }
    @Test
    public void test04() throws IOException {
        // Facebook sayfasına gidiniz
        driver.get("https://facebook.com");
        // ekran görüntüsünü alınız

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String dosyaYolu = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\"+date+"facebook.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void testim() throws IOException {
        driver.get("https://mangasehri.net/manga/one-piece/bolum-165/");
        Actions actions = new Actions(driver);
        WebElement sonraki = driver.findElement(By.xpath("(//a[@class='btn next_page'])[3]"));
        actions.moveToElement(sonraki);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(sonraki));
        String dosyaYolum = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\OnePiece.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolum),ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void testim2() throws IOException {
        driver.get("https://twitter.com/home");
        WebElement ileri = driver.findElement(By.xpath("(//div[@role='button'])[3]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(ileri));
        String dosyaYolu = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\screenShots\\twitter.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));

    }
}
