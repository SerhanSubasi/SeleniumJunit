package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class c01_Iframe extends TestBase {



    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String h3Title = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(h3Title.contains("Editor"));
        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr"); //iframe id'sini yazdık
        WebElement testBox = driver.findElement(By.xpath("//p"));
        testBox.clear();
        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        testBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        driver.switchTo().defaultContent();
        //driver.navigate().refresh(); --> bu da ana sayfaya döndürür,ama frame içindeki değişiklikler de sıfırlanır.

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertEquals("Elemental Selenium", elementalSelenium.getText());

    }







}
