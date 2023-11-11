package day10_cookies_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_CookiesTest extends TestBase {
    /*
    Cookies denildiğinde aklımıza ilk gelmesi gereken şey manage methodudur.
    manage() methodu sayesinde cookiesler ile ilgili tüm işlemler yapılır.
     */

    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie'leri consolda bir loop ile yazdirin

        Set<Cookie> cookies = driver.manage().getCookies(); //Mevcut tüm cookieleri bir set olarak verir.
        int counter = 1;
        for ( Cookie w : cookies) {
            System.out.println( counter + ". cookie => " +w);
            System.out.println( counter + ". cookie Name => " +w.getName());
            System.out.println( counter + ". cookie Value => " +w.getValue());
            counter++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualSize = cookies.size();
        Assert.assertTrue(actualSize>5);

        //4-ismi i18-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        cookies = driver.manage().getCookies();

        int counter1 = 1;
        for ( Cookie w : cookies) {
            System.out.println( counter1 + ". cookie => " +w);
            System.out.println( counter1 + ". cookie Name => " +w.getName());
            System.out.println( counter1 + ". cookie Value => " +w.getValue());
            counter1++;
        }

        //6-eklediginiz cookie'nin sayfaya eklendigini test
        Assert.assertTrue(cookies.contains(cookie));

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();

        int counter2 = 1;
        for ( Cookie w : cookies) {
            System.out.println( counter2 + ". cookie => " +w);
            System.out.println( counter2 + ". cookie Name => " +w.getName());
            System.out.println( counter2 + ". cookie Value => " +w.getValue());
            counter2++;
        }
        Assert.assertFalse(cookies.contains(driver.manage().getCookieNamed("skin")));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies(); // Tüm cookiler silindi.
        cookies = driver.manage().getCookies(); // Cookies'i güncelledik ve boş hale geldi.
        Assert.assertTrue(cookies.isEmpty());

    }


}
