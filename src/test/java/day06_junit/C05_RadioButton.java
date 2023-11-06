package day06_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
         /*
   https://www.facebook.com adresine gidin
           Cookies'i kabul edin
           "Create an Account" button'una basin
           "radio buttons" elementlerini locate edin
           Secili degilse cinsiyet butonundan size uygun olani secin
    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
    }

    @Test
    public void radioButton() {
    WebElement createAccountButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
    createAccountButton.click();
    WebElement femaleRadioButton1= driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
    WebElement maleRadioButton2= driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
    WebElement customRadioButton3= driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));

    if (!maleRadioButton2.isSelected()) {
    maleRadioButton2.click();
     }

    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
