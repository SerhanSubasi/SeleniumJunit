package day13_seleniumwaits_exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebDriverWait extends TestBase {

    /*
    SELENIUM WAIT

    1- Implicitly Wait;
        Driver'ı bir sayfaya gittikten sonra sayfadaki tüm web elementler ile etkileşime girebilmesi için
        belirtmiş olduğumuz max süre kadar bekletir.

    2- Explicit Wait;
        a) WebDriverWait: ==> Default yarım saniyelik aralık

         Sayfa yüklendikten sonra bir WebElement'in etkileşime girebilmesi için max belirtmiş olduğumuz
         süre kadar ve default olarak yarım saniyelik aralıklar ile bekler.

         Örneğin bir web elemente tıkladıktan sonra çıkan bir webelement ya da bir pop-up , alert vs çıkması
         testimizi çalıştırırken farklı sürelerde oluşabilir. Bu süreyi tam olarak belirleyemediğimizden dolayı
         Thread.sleep() kullanmak profesyonelce olmaz.
         Bu gibi durumlarda WebDriverWait ile bir WebElement'in oluşmasını bekletmek daha profesyonel ve dynamic olur.

        b) FluentWait: ==> bizim belirlediğimiz aralık

        Bir WebElement'in sayfa yüklendikten sonra etkileşime girebilmesi için max belirtmiş olduğumuz
        süre kadar ve belirtebileceğimiz aralıklarla bekler.


     */

    @Test
    public void test01() { //1. YÖNTEM İYİDİR

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());

    }

    @Test
    public void test02() {  // 2. YÖNTEM
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

        Assert.assertEquals("Hello World!", helloWorld.getText());

    }

    @Test
    public void test03() {  // 3. YÖNTEM
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement loading = driver.findElement(By.xpath("//*[.='Loading... ']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loading));

        Assert.assertFalse(loading.isDisplayed());
    }


}