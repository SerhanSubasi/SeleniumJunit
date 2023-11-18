package day15_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_ExtentReport {

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
        String path = "target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
       //ExtentReports'a html raporlayıcıyı ekler, bu raporun html formatında oluşturulmasını sağlar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporunun belge başlığını ayarlar, bu başlık sekme üzerinde görünür -head-
        extentHtmlReporter.config().setDocumentTitle("Bacth 189 Test Reports");

        //Raporun adını ayarladık, bu raporda görünecek olan genel başlık -title-
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi aşağıdaki formatta ekleyebiliriz.
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Serhan Subaşı");

        //"AmazonTest" adında yeni bir test oluşturur ve bu testin açıklaması olarak "Test Report" ekler.
        extentTest = extentReports.createTest("Amazon Test","Test Report");


        //==========================BURAYA KADAR ŞABLON AYARLAMALARIYDI==========================//
        //==================BUNDAN SONRA EXTENTTEST OBJESİYLE LOGLAMA YAPACAĞIZ==================//

        //Testin başarılı olduğunu belirtir ve rapora Pass notu ekler
        extentTest.pass("PASS");

        //Testle alakalı bilgilendirici not ekler
        extentTest.info("Bilgilendirme Notu");

        //Testin başarısız olduğunu belirtiriz ve rapora Fail mesajı notu ekleriz.
        extentTest.fail("FAIL");

        //Testle ilgili uyarı mesajı ekler
        extentTest.warning("Uyarı Mesajı");

        //Atlatmak için kullanılır
        extentTest.skip("Atlatma Mesajı");

        //Test sırasında ciddi bir hata olduğunu belirtir
        extentTest.fatal("Ciddi Hata Mesajı");

        extentReports.flush();

    }


}
