package day09_iframe_windowhandle_basicauthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandleDegeri = driver.getWindowHandle();

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandleDegeri = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
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

    @Test
    public void test03() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        List<String> windows = new ArrayList<>( driver.getWindowHandles() );

    /*
        Açılmış olan tüm pencerelerin veya sekmelerin window handle değerlerini getWindowHandles ile aldık.
        Bu method set return eder, ancak setler ile index kullanarak istediğimiz bir elemanı seçmemiz mümkün değildir.
        Bu nedenle biz de bu seti kullanarak bir tane list oluşturduk.
        Çünkü Listlerde get methodu sayesinde index kullanarak istediğimiz sayfaya çok rahat geçiş yapabiliriz.
    */

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(windows.get(0));
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(windows.get(1));
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(windows.get(2));
        waitForSecond(2);

    }

    @Test
    public void test04() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");



        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        waitForSecond(2);

    }

}

