package tests;

import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitionTest extends BaseTests {
    protected ResultPage resultPage;
    private WebDriver driver;

    @Test
    public void testDeveRealizarUmaConsultaQueRetorneUmaListaComPeloMenos3Carros() {
        homePage.deselecionarCarro0km();
        homePage.fecharAviso();
        homePage.selecionarMarca("BMW");
        homePage.selecionarModelo("X1");
        homePage.selecionaAnoMax("2017");
        homePage.selecionarAnoMin("2017");
        homePage.selecionarValorMax("120 mil");
        homePage.selecionarEstado("SÃO PAULO");
        resultPage = homePage.buscar();

    }
    @Test
    public void testValidarModeloEValorAVistaPrimeiroAndSegundoCarroDaListaProduzidaPelaConsulta() {
        testDeveRealizarUmaConsultaQueRetorneUmaListaComPeloMenos3Carros();
       resultPage.obterTamanhoDaList();
       assertEquals("R$ 118.900,00\n" + "preço à vista",resultPage.obterValor(0)); //1° da lista
       assertEquals("R$ 118.900,00\n" + "preço à vista",resultPage.obterValor(1)); //2° da lista
       assertThat(resultPage.obterModelo(0),is("BMW X1 2.0 sDrive20i GP ActiveFlex")); //1° da lista
       assertThat(resultPage.obterModelo(1),is("BMW X1 2.0 sDrive20i GP ActiveFlex")); //2° da lista
    }

}