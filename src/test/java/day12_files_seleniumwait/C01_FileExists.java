package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {
    @Test
    public void test01() {
     // System.getProperty("user.dir") komutu, Java'da programın çalıştığı dizini verir. --> current workind directory
        // C:\Users\Anduril\IdeaProjects\B189SeleniumJunitDT
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));


    //  System.getProperty("user.home") komutu, kullanıcı ana yolunu alır ve string olarak return eder.
        // C:\Users\Anduril
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));


/*
1- Varlığını test etmek isdeğimiz dosyanın yolunu alırız.
2- Aldığımız dosya yolunu Files.exists(Paths.get(dynamicPath)); kodu ile test ederiz.

==> Ortak çalışmalarda bir server üzerinden bir dosya yolu almak istersek her kullanıcının bilgisayarının ana yolu farklı olacaktır.
Ama projedeki dosyanın yeri belli olduğu için buradaki yol herkeste ortaktır.
Dolayısıyla System.getProperty("user.home") methodu ile bilgisayarımızın ana yolunu alabilir ve projedeki ortak yol ile
birleştirerek dinamik ve herkes için çalışan bir forma dönüştürebiliriz.
 */


        //Bilgisayarımızda masaüstünde oluşturduğumuz dosyanın varlığını doğrulayalım.
        // Dosyaya Shift + sağ tık yaparsak dosya olarak kopyala vardır. Veya özellikler - güvenlik kısmında vardır.
        // C:\Users\Anduril\Desktop\Batch189.txt

        String userHome = System.getProperty("user.home");
        String ortakYol = "\\Desktop\\Batch189.txt";
        String dynamicPath = userHome + ortakYol;
        boolean isExist = Files.exists(Paths.get(dynamicPath));
        Assert.assertTrue(isExist);


    }



}
