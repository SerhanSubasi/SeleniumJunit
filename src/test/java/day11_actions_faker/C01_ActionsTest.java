package day11_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsTest extends TestBase {
    @Test
    public void test01() {  //HoverOver - Mousr'u üzerinde bekletmek.

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        Actions actions = new Actions(driver);
        WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(accountLists).perform();
        waitForSecond(3);

    //Acilan sayfanin Title in "Your Account" olduğunu dogrula
    driver.findElement(By.xpath("//span[text()='Account']")).click();
    String actualTitle = driver.getTitle();
    String expectedTitle = "Your Account";
    Assert.assertEquals(expectedTitle,actualTitle);
    }

}
