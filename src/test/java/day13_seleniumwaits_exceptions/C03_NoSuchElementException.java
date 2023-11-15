package day13_seleniumwaits_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_NoSuchElementException extends TestBase {
    /*
           Eğer  NoSuchElementException alıyorsak;
 1-Locate i tekrar kontrol ederiz buna ragmen ayni hatayi aliyorsak
 2-Wait / Synacronization / problemi olabilir, cozum olarak implicitly wait de yeterli sure bekledigimizden emin oluruz, o sureyi arttirabiliriz,
 3-Webelementin iframe icinde olup olmadigini kontrol ederiz,(alert...)
 4-Driver webelementi göremiyordur, dolayisiyla actions classi kullanarak scroll yada baska yöntemlere webelementin görünmesini saglayabiliriz
             */


    @Test
    public void test01() {

driver.get("https://amazon.com");
WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
searchBox.sendKeys("No such element ");
searchBox.submit();

    }


}
