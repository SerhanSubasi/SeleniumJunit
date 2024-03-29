package day06_junit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_JunitIlkTest {

    //Test annotation'ı ekledik ve run yeşil butonu geldi.
    //Her test methodu - public void - olur. Sağ tık ile de yapılabilir.

@Test
public void test1() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://techproeducation.com");
    driver.close();
}

@Test
public void test2() {
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://techproeducation.com");
    driver.close();
}


}
