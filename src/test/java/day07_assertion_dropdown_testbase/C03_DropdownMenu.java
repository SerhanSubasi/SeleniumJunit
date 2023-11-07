package day07_assertion_dropdown_testbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropdownMenu {
    /*
    Dropdown --> Altbaşlıkların olduğu açılır menü listesidir. Dropdown'u automate etmek için
    1- Dropdown menuyu locate edeceğiz.
    2- Select objesi oluştururuz
    3- Select objesini kullanarak bazı methodlar ile istediğimiz seçeneğe erişim sağlarız.
        SYNTAX
        Select select = new Select(Dropdown webelement)
            a- selectBtVisibleText() -> Dropdown menüdeki elemente görünen metin ile ulaşmak için kullanılır.
            b- selectByIndex() -> Index ile ulaşmak için kullanılır. (index 0'dan başlar)
            c- selectByValue() -> value attribute değeri ile ulaşmak için kullanılır. (option tagı ile başlar)

    4- getOptions() -> Locate ettiğimiz dropdown menüdeki tüm seçenekleri bize verir.
    5- getFirstSelectedOption() -> Dropdown menüsündeki seçili olan seçeneği bize verir.
     */

    /*
   Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }



    @Test
    public void test01() {
        //  a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));

        // b. Select objesi olustur
        Select selectYil = new Select(yil);
        Select selectAy = new Select(ay);
        Select selectGun = new Select(gun);

        // c. Select object'i kullaarak 3 farkli sekilde secim yapiniz



        selectYil.selectByIndex(5); //indexe göre seçilir (0'dan başlar)
        selectAy.selectByValue("4"); //option value="4">4</option>
        selectGun.selectByVisibleText("9"); //ekranda görülen değere göre seçilir

    }


    @Test
    public void test02() {
        //  a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletlerDropDown = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);
        List<WebElement> eyaletlerListesiWebElement = select.getOptions();

        for (WebElement w : eyaletlerListesiWebElement ) {
            System.out.println(w.getText());
        }

        /*

    //ikinci yol Lambda
        eyaletlerListesiWebElement.forEach(t-> System.out.println(t.getText()));

        */

    }

    @Test
    public void test03() {



        List<WebElement> eyaletlerListesiWebElement =  driver.findElements(By.xpath("//*[@id='state']/option"));
        eyaletlerListesiWebElement.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test04() {
       // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletlerDropDown = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);
        String expectedOption = "Select a State";
        String actualOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption,actualOption);

    }

    @Test
    public void test05() {
        //genelde dropdown webelementine sendKeys() methodu ile seceneklerden bir tanesini göndererek te secim yapabiliriz
        WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        eyaletlerDropDown.sendKeys("Alabama");

    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }


}
