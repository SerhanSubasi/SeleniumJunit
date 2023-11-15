package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_FluentWait extends TestBase {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).                   //Fluentwait'in maksimum beklemesi gereken süreyi belirtiriz.
                pollingEvery(Duration.ofMillis(200)).               //Fluentwait her 200 milisaniyede bu koşulu kontrol eder.
                withMessage("WebElement ve süreyi kontrol et").     //Eğer belirtilen sürede belirtilen koşul gerçekleşmezse buradaki hata mesajı TimeOutException ile birlikte çıkar.
                until(ExpectedConditions.visibilityOf(helloWorld)); //helloWorld webElementi'nin görünür olup olmadığını kontrol eder
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld = new FluentWait<>(driver).
                 withTimeout(Duration.ofSeconds(20)).
                 pollingEvery(Duration.ofMillis(200)).
                 withMessage("WebElement'i ve süreyi kontrol et").
                 until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }


}
