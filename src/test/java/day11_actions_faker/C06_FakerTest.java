package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Locale;

public class C06_FakerTest extends TestBase {



    @Test
    public void test01() {

        //"https://facebook.com"  Adresine gidin
                driver.get("https://facebook.com");
        //"create new account"  butonuna basin
                driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //"firstName" giris kutusuna bir isim yazin
                WebElement firstNameBox = driver.findElement(By.xpath("//*[@name='firstname']"));
                Locale locale = new Locale("tr");
                Faker faker = new Faker(locale);
                String email = faker.internet().emailAddress();
             // String lastName = faker.name().lastName();
                firstNameBox.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,email
                        ,Keys.TAB,email,Keys.TAB,faker.internet().password(),Keys.TAB);
        //"lastname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        firstNameBox.sendKeys("sa");
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
    }
}
