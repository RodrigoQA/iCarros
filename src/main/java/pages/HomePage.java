package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    List<WebElement> listaProdutos = new ArrayList();

    private By carroZerokm = By.id("anunciosNovos");
    private By fecharPopUp = By.xpath("//*[contains(text(),'OK, ENTENDI')]");
    private By clickMarca = By.xpath("//span[@class='filter-option pull-left'][contains(.,'Marca')]");
    private By setMarca = By.cssSelector("div:nth-child(1).col-xs-6 .form-control");
    private By setModelo = By.cssSelector("div:nth-child(2).col-xs-6 .form-control");
    private By clickAlterar = By.xpath("//*[contains(text(),'alterar')]");
    private By setEstado = By.id("cidade");
    private By selecionaCity = By.cssSelector(".tt-menu div:nth-child(1).tt-suggestion.tt-selectable");
    private By setAnoMax = By.xpath("(//input[@role='textbox'])[4]");
    private By setAnoMin= By.xpath("(//input[@role='textbox'])[3]");
    private By setValorMax = By.xpath("(//input[@type='text'])[6]");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fecharAviso() {
        WebElement fechar = driver.findElement(fecharPopUp);
        if (fechar.isDisplayed()) {
            fechar.click();
        }
    }

    public int contarProdutos() {

        return listaProdutos.size();
    }

    public void deselecionarCarro0km() {
        driver.findElement(carroZerokm).click();

    }

    public void selecionarMarca(String marca) {
        driver.findElement(clickMarca).click();
        driver.findElement(setMarca).sendKeys(marca);
        driver.findElement(By.xpath("//*[contains(text(),'"+marca+"')][@class]")).click();

    }


    public void selecionarModelo(String modelo) {

        driver.findElement(setModelo).sendKeys(modelo);
        driver.findElement(By.xpath("//*[contains(text(),'" + modelo + "')][@class]")).click();

    }

    public void selecionarEstado(String estado) {
        driver.findElement(clickAlterar).click();
        driver.findElement(setEstado).sendKeys(estado);
        driver.findElement(selecionaCity).click();

    }

    public void selecionaAnoMax(String anoMax) {
        driver.findElement(By.xpath("//*[contains(text(),'Ano máx.')][@class]")).click();
        driver.findElement(setAnoMax).sendKeys(anoMax);
        driver.findElement(By.xpath("//*[contains(text(),'Até 2017')][@class]")).click();
    }

    public void selecionarAnoMin(String anoMin) {
        driver.findElement(By.xpath("//*[contains(text(),'Ano min.')][@class]")).click();
        driver.findElement(setAnoMin).sendKeys(anoMin);
        driver.findElement(By.xpath("//*[contains(text(),'De 2017')][@class]")).click();
    }


    public void selecionarValorMax(String valor) {
        driver.findElement(By.xpath("//*[contains(text(),'Preço máx.')][@class]")).click();
        driver.findElement(setValorMax).sendKeys(valor);
        driver.findElement(By.xpath("//span[contains(.,'Até R$ 120 mil')]")).click();

    }
    public ResultPage buscar() {
        driver.findElement(By.xpath("//*[contains(text(),'Buscar')][@class]")).click();
        return new ResultPage(driver);
    }

}

