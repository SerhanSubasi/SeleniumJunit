package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // 1. yöntem

        for (int i = 0; i <4 ; i++) {   //2. yöntem
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }


        waitForSecond(3);

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();

        /*
        Bir sayfada otomation yaparken locate ettiğimiz halde noSuchElementException alıyorsak
        1- Locate'i tekrar kontrol ederiz. Buna rağmen aynı hatayı alıyorsak
        2- Wait / Synacronization  problemi olabilir, çözüm olarak implicity waitde yeterli süre beklediğimizden emin oluruz.
        3- Webelementin iframe içinde olup olmadığını kontrol ederiz. (alert da dahil)
        4- Driver webelementi göremiyordur, dolayısıyla actions class kullanarak scroll ya da başka yöntemlerle webelementin görünmesini sağlayabiliriz.
         */






    }

    @Test
    public void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        waitForSecond(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
        waitForSecond(2);

    }

    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events yazısına kadar scroll yapalım
        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(eventsText).perform();
    }


}
