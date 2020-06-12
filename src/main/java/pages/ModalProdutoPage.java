package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ModalProdutoPage {
    private WebDriver driver;


    private By mensagemProdutoAdicionado = By.id("myModalLabel");
    private By descricaoProduto = By.xpath("//*[@class='h6 product-name']");
    private By precoProduto = By.xpath("//*[@class='product-price']");
    private By listaValoresInformados = By.cssSelector("div.divide-right .col-md-6:nth-child(2) span strong");
    private By continarComprando = By.xpath("//*[@class='btn btn-secondary']");

    public ModalProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String validarMensagemProdutoAdicionado(){
        FluentWait Wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
        return driver.findElement(mensagemProdutoAdicionado).getText();
    }
    public String obterDescricaoProduto(){
        return driver.findElement(descricaoProduto).getText();
    }
    public String obterPrecoProduto(){
        return driver.findElement(precoProduto).getText();
    }
    public String obterTamanhoProduto(){
        return driver.findElements(listaValoresInformados).get(0).getText();
    }
    public String obterCorProduto(){
        return driver.findElements(listaValoresInformados).get(1).getText();
    }
    public String obterQuantidadeProduto(){
        return driver.findElements(listaValoresInformados).get(2).getText();
    }
    public ProdutoPage continuarComprando()  {
         driver.findElement(continarComprando).click();
        return new ProdutoPage(driver);
    }

}
