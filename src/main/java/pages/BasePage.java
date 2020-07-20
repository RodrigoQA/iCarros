package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private static WebDriver driver;
    public void clickText(String text){
        driver.findElement(By.xpath("//*[contains(text(),'" + text + "')][@class]")).click();
        }

    }

