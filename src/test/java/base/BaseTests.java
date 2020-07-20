package base;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
private static WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public static void inicializar(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver\\83\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Before
      public void carregarPaginaInicial(){
        driver.get("https://www.icarros.com.br/principal/index.jsp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //  driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
