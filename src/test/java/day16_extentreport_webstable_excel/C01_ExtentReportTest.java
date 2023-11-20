package day16_extentreport_webstable_excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReportTest extends TestBase {

    @Test
    public void extentReusableFormatTest() {

        rapor("Chrome","AmazonTesti");

        // Amazon Search Box Testi adında yeni bir test oluşturduk ve açıklama olarak üst başlık için TestSteps yazdık
        extentTest = extentReports.createTest("Amazon Search Box Testi","Test Steps");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        extentTest.info("Kullanıcı Amazon ana sayfasına gider");

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium", Keys.ENTER);

        extentTest.info("Arama kutusunda selenium yazılarak aratıldı");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assert.assertTrue(driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfa başlığının selenium içerdiği doğrulandı");

        extentReports.flush();

    }


}
