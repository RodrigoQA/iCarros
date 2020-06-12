package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {

    private WebDriver driver;
    private By nomeProduto = By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]");
    private By tamanhoProduto = By.cssSelector(".product-line-grid-body div.product-line-info:nth-child(4) .value");
    private By corProduto = By.cssSelector(".product-line-grid-body div.product-line-info:nth-child(5) .value");
    private By totalItensProdutos = By.id("cart-subtotal-products");
    private By totalShipping = By.cssSelector("#cart-subtotal-shipping span.value");
    private By totalTaxExcl = By.cssSelector(".cart-summary-totals:nth-child(2) .cart-summary-line:nth-child(1) .value");
    private By totalTaxIxcl = By.cssSelector(".cart-summary-totals:nth-child(2) .cart-summary-line:nth-child(2) .value");
    private By totalTaxas = By.xpath("//*[@class='value sub']");
    private By removerProdutoList = By.xpath("//*[@class='remove-from-cart']");
    private By precoItem = By.cssSelector(".product-line-info  .price");
    private By QtsProduto = By.xpath("//*[@name='product-quantity-spin']");


    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removerProdutoDoCarrinho(int item) throws InterruptedException {
        driver.findElements(removerProdutoList).get(item).click();
        Thread.sleep(3000);
    }

    public String obterPrecoProduto() {
        String precoProduto = driver.findElement(precoItem).getText();
        precoProduto = precoProduto.replace("$", "");
        return precoProduto;
    }

    public String obterQuantidadeProduto() {
        String quantidadeProduto = driver.findElement(QtsProduto).getAttribute("value");
        return quantidadeProduto;
    }
    public String obter_nomeProduto(){
        return driver.findElement(nomeProduto).getText();

    }
    public String obter_tamanhoProduto(){

        return driver.findElement(tamanhoProduto).getText();
    }
    public String obter_corProduto(){
        return driver.findElement(corProduto).getText();
    }
    public String obter_totalItensProdutos(){

        return driver.findElement(totalItensProdutos).getText();
    }
    public String obter_totalShipping(){

        return driver.findElement(totalShipping).getText();
    }
    public String obter_totalTaxExcl(){

        return driver.findElement(totalTaxExcl).getText();
    }
    public String obter_totalTaxIxcl(){
        return driver.findElement(totalTaxIxcl).getText();
    }
    public String obter_totalTaxas(){
        return driver.findElement(totalTaxas).getText();
    }
    public String obter_precoItem(){
        return driver.findElement(precoItem).getText();
    }




}