package day08_testbase_alert_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {

    /*
    Eğer bir sayfadaki bir butona tıkladığınızda bir uyarı çıkıyorsa ve bu çıkan uyarıya sağ click yaparak locate alamıyorsak
    bu bir JS Alerttır. Bunu handle edebilmek için driverımızı o açılan pencereye geçirmemiz gerekir.

    Driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alerte geçiş yapmış oluruz.

    1) accept() ya da dismiss() methodlarıya JS alert'ü onaylar veya iptal ederek kapatırız.

    accept() --> onay
    dismiss() --> red
     */


    @Test
    public void acceptAlert() {
        // Bir metod olusturun: acceptAlert
        //1. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[1]")).click();
        waitForSecond(2);
        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();     //switchTo ile geçiş yaptık.

        // ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        String expectedResultMessage = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultMessage,actualResultMessage);
    }



    //Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
         //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
          driver.findElement(By.xpath("(//button)[2]")).click();
          driver.switchTo().alert().dismiss();
         // ve result mesajının"successfuly" icermedigini test edin.
            String unexpectedMessage = "successfuly";
            String actualMessage =  driver.findElement(By.xpath("(//p)[2]")).getText();

            Assert.assertFalse(actualMessage.contains(unexpectedMessage));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //       3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("blabla");

        // OK tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();
        String actualMessage =  driver.findElement(By.xpath("(//p)[2]")).getText();
        Assert.assertTrue(actualMessage.contains("blabla"));
    }



}
