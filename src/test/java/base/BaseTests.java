package base;

import org.junit.After;
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
        homePage = new HomePage(driver);
    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
