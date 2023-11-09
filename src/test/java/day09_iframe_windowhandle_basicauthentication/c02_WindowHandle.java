package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class c02_WindowHandle extends TestBase {

    /*
    Eğer bir sayfaya gittikten sonra yeni sekme ya da yeni bir pencere açmak istersek bunun için
    driver.switchTo().newWindow() methodunu kullanmalıyız. Bu method parantez içinde yeni açılacak olan sayfanın
    bir sekme mi yoksa yeni pencere mi olduğunu aşağıdaki kodlar ile belirtir.

   1) driver.switchTo().newWindow(WindowType.WINDOW) -yeni pencere açar ve buraya geçiş yapar-
   2) driver.switchTo().newWindow(WindowType.TAB)   -yeni sekme açar ve buraya geçiş yapar-

   eğer handle değeri ile bir sayfaya geçiş yapmak istersek bu defa da  driver.switchTo().window() methodunu kullanarak
   parantez içine geçiş yapmak istediğimiz sayfanın handle değerini belirtmemiz gerekir.
     */

    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandleDegeri = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandleDegeri = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandleDegeri = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandleDegeri);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandleDegeri);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandleDegeri);
        waitForSecond(2);

    }


}
