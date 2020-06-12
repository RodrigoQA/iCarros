package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    List<WebElement> listaProdutos = new ArrayList();

    private By valorDeProdutosNoCarrinho = By.className("cart-products-count");
    private By produtos = By.className("product-description");
    private By descriscaoProdutos = By.cssSelector(".product-description a");
    private By valorProdutos = By.cssSelector(".product-price-and-shipping .price");
    private By btnSingIn = By.id("_desktop_user_info");
    private By usuarioLogado = By.cssSelector("#_desktop_user_info span.hidden-sm-down");
    private By myStory = By.id("_desktop_logo");
    private By cart_click = By.xpath("//*[@id='_desktop_cart']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void carregarListaProdutos() {
        listaProdutos = driver.findElements(produtos);
    }

    public int contarProdutos() {
        carregarListaProdutos();
        return listaProdutos.size();
    }

    public int obterquantidadesDeProdutosNoCarrinho() {
        String quantidadeDeProdutosNoCarrinho = driver.findElement(valorDeProdutosNoCarrinho).getText();
        quantidadeDeProdutosNoCarrinho = quantidadeDeProdutosNoCarrinho.replace("(", "");
        quantidadeDeProdutosNoCarrinho = quantidadeDeProdutosNoCarrinho.replace(")", "");

        int qtsDeProdutosNoCarrinho = Integer.parseInt(quantidadeDeProdutosNoCarrinho);
        return (qtsDeProdutosNoCarrinho);

    }

    public String obterNomeProduto(int indice) {
        return driver.findElements(descriscaoProdutos).get(indice).getText();

    }

    public double obterValorProduto(int indice) {
        String valor = driver.findElements(valorProdutos).get(indice).getText();
        valor = valor.replace("$", "");
        double valorDoProduto = Double.parseDouble(valor);
        return valorDoProduto;

    }

    public ProdutoPage clicarNoProduto(int indice) {
        driver.findElements(descriscaoProdutos).get(indice).click();
        return new ProdutoPage(driver);
    }
    public LoginPage click_SingIn(){
        driver.findElement(btnSingIn).click();
        return new LoginPage(driver);
    }
    public String estaLogado(){
     String nomeUsuario =  driver.findElement(usuarioLogado).getText();
        return nomeUsuario;
    }
    public boolean estaLogado2(String usuario){
        return driver.findElement(usuarioLogado).getText().contentEquals(usuario);
    }
    public HomePage PaginaInicial(){
        driver.findElement(myStory).click();
        return new HomePage(driver);
    }
    public CarrinhoPage visualizarCarrinho()  {

        driver.findElement(cart_click).click();
        return new CarrinhoPage(driver);
    }
}

