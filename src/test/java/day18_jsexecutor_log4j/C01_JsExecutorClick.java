package day18_jsexecutor_log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {

    /*
            ElementClickInterceptedException: Locate'ini almış olduğumuz bir web elementin önünde başka bir web element açılırsa,
            click yapılamıyor ve bu hatayı veriyor.
             */

    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //sell linkine tıklayalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);
    }

    @Test
    public void test02() {  //DataBase'e method oluşturduktan sonraki kolay kullanım örneği
        //amazona gidelim
        driver.get("https://amazon.com");

        //sell linkine tıklayalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLinki);
    }

}
