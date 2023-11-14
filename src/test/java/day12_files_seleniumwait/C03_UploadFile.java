package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_UploadFile extends TestBase {
    @Test
    public void uploadTest() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim. CLICK YAPILMAYACAK UPLOADDA!
        // C:\Users\Anduril\Downloads\b10 all test cases, code.docx
        String userHome = System.getProperty("user.home");
        String dosyaYolu = "\\Downloads\\b10 all test cases, code.docx";
        String dynamicPath = userHome + dosyaYolu;

        chooseFile.sendKeys(dynamicPath);

        waitForSecond(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedTest = "File Uploaded!";
        Assert.assertEquals(expectedTest,actualText);

        waitForSecond(2);
    }
}
