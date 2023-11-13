package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_TestActions extends TestBase {

    @Test
    public void test01() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT). //Arama kutusunda shift tusuna basılı tutar
                sendKeys("selenium").
                keyUp(Keys.SHIFT).  //Shift tuşunu basmayı bıraktırdık
                sendKeys("-java",Keys.ENTER).
                perform();

        waitForSecond(3);
    }

    @Test
    public void test02() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"selenium", Keys.SHIFT,"-java");
        waitForSecond(3);
    }

    @Test
    public void testOdev() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium",Keys.ENTER);
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.CONTROL,"a");
        searchBox.sendKeys(Keys.CONTROL,"x");
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.get("https://google.com");
        WebElement searchBox2 = driver.findElement(By.id("APjFqb"));
        searchBox2.sendKeys(Keys.CONTROL,"v",Keys.ENTER);
        waitForSecond(2);
    }





}
