package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ExtentReportTest extends TestBase {

     /*
    1- ExtentReport class'ından raporlamayı başlatması için bir object oluşturmalıyız.
    2- ExtentHtmlReporter class'ından raporları html formatında oluşturması için bir object oluşturmalıyız.
    3- ExtentTest Class'ından test adımlarına bilgi ekleyebilmek için bir object oluştururuz.
     */

        ExtentReports extentReports;                //raporlamayı başlatır
        ExtentHtmlReporter extentHtmlReporter;      //html formatında rapor oluşturur
        ExtentTest extentTest;                      //test adımlarına bilgi ekler

        @Test
        public void extentReportTemplate() {

            // Bu objecti raporlamayı başlatmak ve yönetmek için kullanacağız.
            extentReports = new ExtentReports();

            //Bir dosya yolu oluşturmamız lazım.
            String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
            String path = "target/extentReport/" + date + "htmlReport.html";
            extentHtmlReporter = new ExtentHtmlReporter(path);
            //ExtentReports'a html raporlayıcıyı ekler, bu raporun html formatında oluşturulmasını sağlar
            extentReports.attachReporter(extentHtmlReporter);

            //Html raporunun belge başlığını ayarlar, bu başlık sekme üzerinde görünür -head-
            extentHtmlReporter.config().setDocumentTitle("Bacth 189 Test Reports");

            //Raporun adını ayarladık, bu raporda görünecek olan genel başlık -title-
            extentHtmlReporter.config().setReportName("Smoke Test");

            //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi aşağıdaki formatta ekleyebiliriz.
            extentReports.setSystemInfo("Enviroment", "QA");
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("Test Automation Engineer", "Serhan Subaşı");

            //"AmazonTest" adında yeni bir test oluşturur ve bu testin açıklaması olarak "Test Report" ekler.
            extentTest = extentReports.createTest("Techproeducation Test", "Test Report");


            //==========================BURAYA KADAR ŞABLON AYARLAMALARIYDI==========================//

            //TechproEducation sayfasina gidelim
            driver.get("https://techproeducation.com");
                extentTest.info("Kullanıcı TechproEducaiton sayfasına gider");

            //TechproEducation ana sayfada oldugunuzu dogrulayin
            String expectedUrl = "https://techproeducation.com/";
            Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
                extentTest.info("Kullanıcı ana sayfada olduğunu doğrular");
                extentTest.pass("Ana sayfa url testi başarılıdır");

            //Ana Sayfa sag üst kısımda sosyal medya iconlarinin goruntulendigini dogrulayin
            WebElement icons = driver.findElement(By.xpath("//*[@class='toolbar-sl-share']"));
            Assert.assertTrue(icons.isDisplayed());
                extentTest.pass("Kullanıcı iconların görüntülendiğini doğrular");


                extentReports.flush();

        }
    }
