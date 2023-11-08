package day08_testbase_alert_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
    /*
    Bir HTML dökümanının içine yerleştirilmiş başka bir HTML dökümanına inline Frame (iFrame) denir.
    iframe'i handle etmek için driverımızı iframe'e geçiş yaptırmamız gerekir.

    üç farklı yöntemle iframe'e geçiş yapabiliriz.
    1) driver.switchTo.frame(sayfadaki iframe'in indexi -0'dan başlar-)
    2) driver.switchTo.frame(<iframe> tagındaki id / name attribute değeri)
    3) driver.switchTo.frame(iframe'in locate'i)

    tekrar ana sayfaya geçmek istersek defaultContent() methodi ile iframe'den çıkıp ana sayfaya geçeriz.
    Eğer iç içe iframelere geçiş yaptıysak, bir üst frame'e geçiş yapmak için parentFrame() methodunu kullanırız.
     */







    @Test
    public void test() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0); //index kullanarak iframe'e geçiş yaptık
        WebElement applicationListWE = driver.findElement(By.xpath("//*[.='Applications Lists']"));
        Assert.assertEquals("Applications lists",applicationListWE.getText());


        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().parentFrame(); //Anasayfaya geçiş yaptık
        WebElement iframe =  driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("iframe",iframe.getText());

    }
}
