package day16_extentreport_webstable_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

    /*

    1- <table> bu tag tüm tabloyu kapsar, xpath kullanarak //table ile tüm tabloları bulabiliriz.
        Birden fazla tablodan istediğimiz tabloyu seçebilmek için index belirtiriz. //table[2]

    2- <thead> bu tag eğer webTable'da bir başlık bölümü varsa thead içinde yer alır.
        <thead> tagı içinde <tr> (table row) başlık satırını || <th> ise başlık satırındaki her bir hücreyi temsil eder.

    3- <tbody> bu tag webTable'daki dataların yoğun olarak bulunduğu kısımdır.
        <tr> satırları || <td> satırlardaki hücreleri temsil eder.

     */


    @Test
    public void webTableTest() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());
        System.out.println("==================================================");

        //Task 2 : 3. Row'(satır) datalarını print edin
        WebElement tr3 = driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println(tr3.getText());
        System.out.println("==================================================");

        //Task 3 : Son row daki dataları print edin
        WebElement tr4 = driver.findElement(By.xpath("//table[1]//tbody//tr[last()]"));
        /*
        son satırı dinamik olarak locate etmek istersek index parantezi içinde last() kullanırız.
        last() ile dinamik olur ama //tbody de girdik çünkü hem body hem head'i alıyordu aksi halde.
         */
        System.out.println(tr4.getText());
        System.out.println("==================================================");
        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> sütun5 = driver.findElements(By.xpath("//table[1]//tbody//td[5]"));
        for ( WebElement w: sütun5) {
            System.out.println(w.getText());
        }
        System.out.println("==================================================");

        //2. yol
        sütun5.forEach(t-> System.out.println(t.getText()));
        System.out.println("==================================================");

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        printdata( 1,2,3);
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin


    }

    private void printdata( int table ,int satir, int sütun) {
        WebElement webElement = driver.findElement(By.xpath("//table["+table+"]//tbody//tr["+satir+"]//td["+sütun+"]"));
        System.out.println(webElement.getText());
    }


}
