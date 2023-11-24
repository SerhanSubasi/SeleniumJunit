package day19_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorStyle extends TestBase {

    @Test
    public void test01() {  //Style değiştirmek
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //aramakutusunun style özelliklerini degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        //searchBox webElementi'nin etrafına 5 pixsel kırmızı bir çerçeve ekledik.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'",searchBox);

        //searchBox webElementi'nin arkaplan rengini değişirdik.
        js.executeScript("arguments[0].style.backgroundColor='brown'",searchBox);

        //searchBox webElementi'nin metin rengini beyaza çevirdik
        js.executeScript("arguments[0].style.color='white'",searchBox);


        //sayfanin ekran görüntüsünü alalim
        screenShot();
    }


}
