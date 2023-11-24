package day19_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Log4j extends TestBase {
    /*
    1- Log4j kullanabilmek için öncelikle Log4j-core ve log4j-api değendencyleri pom.xml dosyasına ekleriz.
    2- Proje seviyesinde bir tane log4j.xml dosyası oluşturup, configuration için xml kodlarını bu dosyaya ekleriz.
    (resources açarak root yapmayı unutma)

     */

    @Test
    public void test01() {
        //  LogManager.getLogger(C02_Log4j.class); kodu parantez içinde belirtilen class için Logger objecti oluşturur.
       Logger logger = LogManager.getLogger(C02_Log4j.class);

       // amazon sayfasına gidelim
        driver.get("https://amazon.com");
       logger.info("Amazon web sayfasına gidildi.");
       // arama kutusu locate edilmeli
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
       logger.info("Arama kutusu locate edildi.");

       //Arama kutusuna 'selenium' aratılmalı.
        searchBox.sendKeys("selenium");
       logger.info("Arama kutusunda 'selenium' aratıldı.");

// pom.xml altına selenium.log gelmiştir, artık orası log kayıtlarının tutulduğu yer.
    }




}
