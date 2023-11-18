package day15_screenshot_extentreport;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ScreenShotClassWork extends TestBase {


        @Test
        public void test01() {

            //Techproeducation sayfasına gidelim
            driver.get("https://techproeducation.com");

            //Ana sayfanın başarıyla yüklendiğini doğrula.
            String expectedUrl = "https://techproeducation.com/";
            Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

            //Sayfanın ekran görüntüsünü alin
            screenShot();

            //Sayfada görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
            WebElement phoneNumber = driver.findElement(By.xpath("(//a[.='+1 585 304 29 59'])[1]"));
            String expectedPhoneNumber = "+1 585 304 29 59";
            Assert.assertEquals(expectedPhoneNumber,phoneNumber.getText());

            //Techpro ana sayfasi en altta logonun görüntülendigini dogrulayin


            //logonun ekran goruntusunu alalım


        }
}
