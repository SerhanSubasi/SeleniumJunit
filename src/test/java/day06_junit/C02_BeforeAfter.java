package day06_junit;

import org.junit.*;

public class C02_BeforeAfter {

    // Before - AfterClass static olmak zorundadır. Çünkü classtan önce bir kez çalışıyor.

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("@BeforeClass Class'tan önce bir kez çalışır.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before her test methodundan önce bir kez çalışır.");
    }

    @Test
    public void Test01() {
        System.out.println("Test01 çalıştı");
    }

    @Test
    public void Test02() {
        System.out.println("Test02 çalıştı");
    }

    @Test
    public void Test03() {
        System.out.println("Test03 çalıştı");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After her test methodundan sonra bir kez çalışır.");
    }


    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@Afterclass Class'tan sonra bir kez çalışır.");
    }

}
