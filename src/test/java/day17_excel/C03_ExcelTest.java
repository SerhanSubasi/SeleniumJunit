package day17_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ExcelTest extends TestBase {

    @Test
    public void test01() throws IOException {


        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalım
        driver.findElement(By.xpath("//a[.=' Login']")).click();

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String path = "C:\\Users\\Anduril\\IdeaProjects\\B189SeleniumJunitDT\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        String userEmail = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String userPassword= workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailBox = driver.findElement(By.id("formBasicEmail"));
        emailBox.sendKeys(userEmail);

        WebElement passwordBox = driver.findElement(By.id("formBasicPassword"));
        passwordBox.sendKeys(userPassword);

        driver.findElement(By.xpath(" //button[text()=' Login']")).click();

        waitForSecond(5);

        //Login olduğumuzu doğrulayalım



    }
}
