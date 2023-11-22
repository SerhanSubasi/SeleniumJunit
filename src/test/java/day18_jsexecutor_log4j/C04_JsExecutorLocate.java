package day18_jsexecutor_log4j;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutorLocate extends TestBase { //id'si shadow'a gömülü olan senaryolarda locate alabilmek için yapılır.
    @Test
    public void test01() { //shadow içinde yazılmışsa kod locate edilemez, JS gerekir.

        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html   adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement helloShadowDomWe = (WebElement) js.executeScript(" return document.getElementById('content');"); //bu yazıyı incele - script içinden aldık
        Assert.assertEquals("Hello Shadow DOM",helloShadowDomWe.getText());
    }

    @Test
    public void amazonTest() {
        //amazon a gidin
        driver.get("https://amazon.com");
        //arama kutusunda selenium yazin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        //arama kutusuna basarili bir sekilde yazinin gönderildigini test edin
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String searchBoxValue = js.executeScript("return document.getElementById('twotabsearchtextbox').value").toString();
        System.out.println(searchBoxValue);
        Assert.assertEquals("selenium",searchBoxValue);
    }


}
