package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;


    private By getEmail = By.xpath("//input[@name=\"email\" ][@class=\"form-control\"]");
    private By getPassword = By.name("password");
    private By btnLogar = By.id("submit-login");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inserirEmail(String email){
        driver.findElement(getEmail).sendKeys(email);
    }
    public void inserirSenha(String senha){
        driver.findElement(getPassword).sendKeys(senha);
    }
    public HomePage fazerLogin(){
        driver.findElement(btnLogar).click();
        return new HomePage(driver);
    }
}
