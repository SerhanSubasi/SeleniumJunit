package day13_seleniumwaits_exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ODEV extends TestBase {
    @Test
    public void Odev() {

        //    https://www.amazon.com.tr/ bağlantısını açın
        driver.get("https://www.amazon.com.tr/");
        //    tümü menüsünü açın
        driver.findElement(By.className("hm-icon-label")).click();
        waitForSecond(2);
        //    Ayakkabı seçeneğini seçin.
        driver.findElement(By.xpath("//a[@data-ref-tag='nav_em_1_1_1_6']")).click();
        waitForSecond(3);
        //    'Çizme ve Bot' alt menüsüne tıklayın.
        driver.findElement(By.xpath("(//a[text()='Çizme ve Bot'])[1]")).click();
        //    Random belirlediğiniz bir çizme veya botu seçiniz.
        driver.findElement(By.xpath("(//li[@class='octopus-pc-item octopus-pc-item-v3'])[1]")).click();
        //    ürünün ayak numarasını belirleyin.
        driver.findElement(By.xpath("//span[@id='size_name_6']")).click();
        //    ürünün stokta olup olmadığını kontrol edin.
        WebElement stoktaVarsaText = driver.findElement(By.xpath("//*[text()=' Stokta sadece 2 adet kaldı. ']"));
        WebElement stoktaVarText = driver.findElement(By.xpath("//*[.=' Stokta var ']"));
        if (stoktaVarText.isDisplayed() && stoktaVarsaText.isDisplayed()) {
            //    stokta varsa ürünü sepete ekleyiniz.
            driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])")).click();
        } else {
            //    Stokta yoksa başka ayak numarası seçiniz.
            driver.findElement(By.xpath("//span[@id='size_name_5']")).click();
        }
        //    Sepete gidiniz.

        //    Ürünün fiyat, renk ve numarasının aynı olduğunu doğrulayınız.

    }




}
