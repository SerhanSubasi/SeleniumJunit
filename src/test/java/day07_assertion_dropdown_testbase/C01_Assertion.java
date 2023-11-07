package day07_assertion_dropdown_testbase;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {

    /*
    Assertion, bir test sırasında beklenen (expected) ve gerçek (actual) sonuçlar arasındaki uyumu doğrulamak için kullanılır
    Eğer beklenen sonuç gerçekleşen sonuç ile uyuşmuyorsa assertion exception fırlatılır ve test failed olur.
    Junit'te bir assertion failed olduğunda o anda çalışmakta olan test methodu durdurulur ve bir assertion error fırlatılır.
    Bu, ilgili testin başarısız olduğu anlamına gelir.
    Ancak test sınıfı içindeki diğer test methodları bu durumdan etkilenmez ve kendi içindeki assertionlar başarısız olmadıkça
    çalışmaya devam ederler.
     */

    /*
    1. assertEquals(expected, actual): parantezi içinde belirtilen iki değerin eşit olup olmadığını kontrol eder.
    Eşitse test başarılır olur, değilse başarısız olur.
    */

    @Test
    public void test01() {
        String expectedData = "selenium";
        String actualData = "selenium";
        Assert.assertEquals(expectedData,actualData);
    }

    /*
    2. assertTrue(boolean); parantezi içinde belirtilen koşulun doğru olup olmadığını kontrol eder.
    Eğer parantez içindeki değer true ise test başarılır olur, false ise failed olur.
     */

    @Test
    public void test02() {
        Assert.assertTrue("selenium".contains("e"));
    }

    /*
    3. assertFalse(boolean); parantezi içinde belirtilen koşulun yanlış olup olmadığını kontrol eder.
    Eğer parantez içindeki değer false ise test başarılır olur, true ise failed olur.
     */

    @Test
    public void test03() {
        Assert.assertFalse("selenium".contains("E"));    //Pass
        Assert.assertFalse("selenium".contains("e"));   //Fail
    }

    /*
    4. assertNotEquals(expected,actual): içerisinde belirtilen parametreler eşit değilse test başarılı olur.
    Eğer eşit ise test failed olur.
     */

    @Test
    public void test04() {
        String unexpectedData = "selenium";
        String actualData = "melenium";
        Assert.assertNotEquals(unexpectedData,actualData);
    }



}
