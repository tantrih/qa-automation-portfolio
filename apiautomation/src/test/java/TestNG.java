import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
    String name ="AfterOffice12";

    @BeforeClass
    public void setUpClass(){
        System.out.println("ini untuk setup class");
        // scenario login
        // set API, Set credential
    }
    
    @Test
    public void checkoutBarang(){
        //check out barang
        /*
        Login
        checkout
         */
    }

    //Before method berfungsi untuk menjalankan function sebelum masing2 test dijalankan
    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }

    @Test
    public void scenarioTest1(){
        Assert.assertEquals(name, "AfterOffice12");
        System.out.println("Scenario 1");
    }

    @Test
    public void scenarioTest2(){
        Assert.assertEquals(name, "AfterOffice11");
        System.out.println("Scenario 2");
    }

    @Test
    public void scenarioTest3(){
        Assert.assertEquals(name, "AfterOffice12");
        System.out.println("Scenario 3");
    }

    // dijalankan setiap skenario test selesai dijalankan
    @AfterMethod
    public void afterUp(){
        System.out.println("after method");
    }

    @AfterClass
    public void setUpAfterClass(){
        System.out.println("ini adalah untuk setup after class");
    }
}
