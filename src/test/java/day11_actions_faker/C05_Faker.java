package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C05_Faker {

    /*
Belirli bir bölgeye göre isim oluşturmak için locale classından obje oluştururuz ve faker constructorı içinde belirtiriz.
Locale locale = new Locale("tr");
Faker faker = new Faker(locale);
 */


    @Test
    public void faker() {
        Faker faker = new Faker();
    //faker objesi ile fake bir isim yazdırınız
        String firstName = faker.name().firstName();
        System.out.println(firstName);
    //faker objesi ile fake bir soyisim yazdırınız
        String lastName = faker.name().lastName();
        System.out.println(lastName);
    //faker objesi ile fake bir adres yazdırınız
       String fullAdress = faker.address().fullAddress();
        System.out.println(fullAdress);
    //faker objesi ile fake bir telefon no yazdırınız
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println(phoneNumber);
    //faker objesi ile fake bir email yazdırınız
        String email = faker.internet().emailAddress();
        System.out.println(email);
    //faker objesi ile fake bir rastgele 15 haneli bir sayı yazdırınız
        String number = faker.number().digits(15);
        System.out.println(number);
    //faker objesi ile fake bir isim soyisim yazdırınız
    String fullName = faker.name().fullName();
        System.out.println(fullName);
    }


}
