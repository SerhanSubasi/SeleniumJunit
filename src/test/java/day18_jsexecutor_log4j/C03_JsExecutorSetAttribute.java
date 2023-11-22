package day18_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutorSetAttribute extends TestBase {
    /*
      Eğer sendkeys çalışmıyorsa js ile de yazdırabiliriz.
        */

    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdıralım
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='selenium'",searchBox);
    }

    @Test
    public void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdıralım
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(searchBox,"selenium");
    }

    @Test
    public void setAttribute() { //id değerinin değiştirilebileceği senaryo (her seferinde farklı id ile gelen sayfalarda kullanılabilir)

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusu id attribute değerini ismimiz ile değiştirelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','Serhanko')",searchBox);

        //değiştirmiş olduğumuz id ile arma kutusunu locate ederecek java aratalım
        driver.findElement(By.id("Serhanko")).sendKeys("java");


    }

}
