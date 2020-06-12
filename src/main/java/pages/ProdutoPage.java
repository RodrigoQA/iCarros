package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProdutoPage {
    private WebDriver driver;

    private By descriscaoProduto = By.cssSelector(".h1");
    private By valorProduto = By.cssSelector(".current-price span:nth-child(1)"); //´Para quando temos 2 items na mesma class unica
    private By tamanhoProduto = By.id("group_1");
    private By ADD_TO_CART = By.xpath("//*[@class='btn btn-primary add-to-cart']");
    private By corBranca = By.xpath("//*[@name='group[2]'][@value='8']");
    private By corPreta = By.xpath("//*[@name='group[2]'][@value='11']");
    private By quantidadeProdutos = By.xpath("//*[@name='qty']");
    private By produtosNoCarrinho = By.className("cart-products-count");
    private By cart_click = By.xpath("//*[@id='_desktop_cart']");
    private By myStory = By.cssSelector("#_desktop_logo");

    public ProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public  String obterNomeProduto() {
        return driver.findElement(descriscaoProduto).getText();

    }
    public double obterValorProduto() {
        String valor = driver.findElement(valorProduto).getText();
        valor = valor.replace("$", "");
        double valorDoProduto = Double.parseDouble(valor);
        return valorDoProduto;
    }

    public void selecionarOpcaoDropDrown(String opcao){
        encontrarDropDownSize().selectByVisibleText(opcao);
    }

    public List<String> obterOpcoesSelecionadas(){
        List<WebElement> elementosSelecionados =
                encontrarDropDownSize().getAllSelectedOptions();

        List<String> listaOpcoesSelecionadas = new ArrayList();
        for ( WebElement elemento : elementosSelecionados ){
            listaOpcoesSelecionadas.add(elemento.getText());
        }
        return listaOpcoesSelecionadas;
    }

    public Select encontrarDropDownSize(){
        return new Select(driver.findElement(tamanhoProduto));
    }
    public void selecionarCorBranca(){
        driver.findElement(corBranca).click();
    }
    public void selecionarCorPreta(){
        driver.findElement(corPreta).click();
    }
    public ModalProdutoPage click_addtocart(){
        driver.findElement(ADD_TO_CART).click();
        return new ModalProdutoPage(driver);
    }
    public void informarQuantidade(int Qts){
        driver.findElement(quantidadeProdutos).clear();
        driver.findElement(quantidadeProdutos).sendKeys(Integer.toString(Qts));
    }
    public String obterQuantidade(){
     return  driver.findElement(quantidadeProdutos).getAttribute("value");

    }
    public String obterQuantidadeDeProdutosNoCarrinho(){
        String QtsCarrinho = driver.findElement(produtosNoCarrinho).getText();
        return QtsCarrinho;
    }
    public CarrinhoPage visualizarCarrinho()  {

        driver.findElement(cart_click).click();
        return new CarrinhoPage(driver);
    }
    public HomePage paginaInicial() throws InterruptedException {
        driver.findElement(myStory).click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }
}
