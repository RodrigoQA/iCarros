package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;
    public void clickText(String text){
        driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]")).click();
        }

    }
}
