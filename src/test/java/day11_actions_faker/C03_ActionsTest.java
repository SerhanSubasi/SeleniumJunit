package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drag,drop).perform();  //Drag webelemnt'ini drop webelement'ine bırakırız.
        waitForSecond(3);
    }

    @Test
    public void test02() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.clickAndHold(drag).     //Drag webelementini tut ve bekle
                moveToElement(drop).   // Drag webelementini tutup drop webelementinin üzerine götür
                release().             // Basılı tuttuğumuz webelementini bırak
                perform();

            waitForSecond(2);
    }

    @Test
    public void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.clickAndHold(drag).moveByOffset(161,22).release().perform();
waitForSecond(4);
    }

/*
NOT: Konumlar incele sayfasının sağ köşesinde görünüyor, oradan bakıp nokta atışı bulabilirsin.
 */

 // Homework Drad webelementinin drop webelementinin üzerine bırakıldığını doğrulayınız.




}
