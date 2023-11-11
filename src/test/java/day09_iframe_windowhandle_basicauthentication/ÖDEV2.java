package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.database.Database;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class ÖDEV2 extends TestBase {

    @Test
    public void test() {
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select SelectByIndexTest = new Select(ddm);
        SelectByIndexTest.selectByIndex(1);
        //2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
        Select SelectByValueTest = new Select(ddm);
        SelectByValueTest.selectByValue("2");
        //3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        Select SelectByVisibleTextTest = new Select(ddm);
        SelectByVisibleTextTest.selectByVisibleText("Option 1");
    }

    //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
    @Test
    public void printAllTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        List<WebElement> allOptions = select.getOptions();



        for (  WebElement w: allOptions) {
            System.out.println(w.getText());
            if (w.getText().contains("Option 2")) {
                Assert.assertTrue(w.getText().contains("Option 2"));
            }
        }
    }

    @Test
    public void test03() {
        //5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        String expectedText = "Please select an option";
        Assert.assertEquals(expectedText,select.getFirstSelectedOption().getText());
    }

    @Test
    public void sizeTest() {
        //6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        int allOptionsList = select.getOptions().size();
        int expectedNumber = 3;
        Assert.assertEquals(expectedNumber,allOptionsList);
    }
}
