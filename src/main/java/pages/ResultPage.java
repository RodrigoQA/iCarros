package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {
    List<WebElement> listaVeiculos = new ArrayList();
    private WebDriver driver;


    private By modeloVeiculos = By.cssSelector(".esquerda.titulo_anuncio");
    private By valorVeiculos = By.cssSelector(".direita.preco_anuncio"); //´Para quando temos 2 items na mesma class unica
    private By tamanhoList = By.cssSelector(".anuncio.anuncio");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterModelo(int list) {
        String descricao = driver.findElements(modeloVeiculos).get(list).getText();
        System.out.println(descricao);
        return descricao;

    }
    public String obterValor(int list) {
        String valor = driver.findElements(valorVeiculos).get(list).getText();
        valor.replace("preço à vista","");
        System.out.println(valor);
        return valor;
    }
    private void carregarListaVeiculos() {
        listaVeiculos = driver.findElements(tamanhoList);
    }
    public int obterTamanhoDaList(){
     carregarListaVeiculos();
        System.out.println(listaVeiculos.size());
     return listaVeiculos.size();

    }




}
