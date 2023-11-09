package day09_iframe_windowhandle_basicauthentication;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class ÖDEV {
    static WebDriver driver;

  // BeforeClass methoduyla driveri oluşturun ve pencereyi maximize edin ve 15 saniye implicitli wait koyun
    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Before methodu ile http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }

    @Test
    public void masaustuTest() {

   //  3 farklı test methoduyla:
   // ->Arama kutusuna "Masaüstü" yazın ve sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys("Masaüstü");
        searchBox.submit();


    }

    @Test
    public void telefonTest() {
        // ->Arama kutusuna "Akıllı Telefon" yazın ve sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys("Akıllı Telefon");
        searchBox.submit();

    }

    @Test
    public void dizustuTest() {
        //Arama kutusuna "Dizüstü Bilgisayar" yazın ve sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys("Dizüstü Bilgisayar");
        searchBox.submit();

    }


    // NOT: Sonuç sayilarini After method icinde yazdırın
    @After
    public void tearDown() throws Exception {
        WebElement text = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String [] splitedText = text.getText().split(" ");


        System.out.println("Arama Sonuçları = " + splitedText[1]);


    }


    // AfterClass methoduyla driver i kapatın
    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }
}
