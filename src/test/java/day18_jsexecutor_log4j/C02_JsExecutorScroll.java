package day18_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorScroll extends TestBase {

    @Test
    public void scrollwithJS() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //Challenges a kadar scroll yapiniz
        WebElement challengesText = driver.findElement(By.xpath("//*[.='Challenges']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",challengesText); //true yazınca parametre olarak, ekranın yukarısında görünür, false olursa aşağıda.
    }

    @Test
    public void scrollWithJS2() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //x-y ekseninde piksel miktarı giriyoruz.
    }

}
