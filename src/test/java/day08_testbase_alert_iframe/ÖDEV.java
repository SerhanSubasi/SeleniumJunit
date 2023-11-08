package day08_testbase_alert_iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class ÖDEV extends TestBase {




    @Test
    public void test() {
        //https://html.com/tags/iframe/ sayfasina gidiniz
        driver.get("https://html.com/tags/iframe/");
        //sayfada bulunan youtube videosunu baslatiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay']")).click();
        waitForSecond(5);
    }

}
