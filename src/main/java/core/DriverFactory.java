package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DriverFactory {

    private static WebDriver driver;
    static Logger log = Logger.getLogger("QALogger");

    public static WebDriver getDriver() {
        if (driver == null) {
            // Inicia driver
            createDriver();
        }
        return driver;

    }


    private static void createDriver() {

        try {
            System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver\\83\\chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            log.info("Chrome Driver selecionado");


        } catch (Throwable e) {
            System.out.println("ERRO: " + e.getMessage());
        }


    }

    // Finaliza driver
    public static void killDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
