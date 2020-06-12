package homepage;

import base.BaseTests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageTest extends BaseTests {
    protected ProdutoPage produtoPage;
    protected LoginPage loginPage;
    protected ModalProdutoPage modalProdutoPage;
    protected CarrinhoPage carrinhoPage;
    String tamanhoProduto = "XL";
    String corProduto = "Black";
    int quantidadeProduto = 3;
    private WebDriver driver;
    @Test
    public void testContarProdutos_OitoProdutosDiferentes(){

        assertThat(homePage.contarProdutos(), is(8));
    }
    @Test
    public void testValidarCarrinhoVazio_ZeroItensNoCarrinho(){

        int produtosNoCarrinho =  homePage.obterquantidadesDeProdutosNoCarrinho();
        assertThat(produtosNoCarrinho, is(0));

    }
    @Test
    public void testValidarDetalhesDoProduto_DescriscaoEValorIguais()  {
        int indice = 0;
        String nomeProduto_HomePage = homePage.obterNomeProduto(indice);
        double valorProduto_HomePage = homePage.obterValorProduto(indice);
        produtoPage = homePage.clicarNoProduto(indice);
        String nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
        double valorProduto_ProdutoPage = produtoPage.obterValorProduto();
        assertTrue(valorProduto_ProdutoPage == valorProduto_HomePage);
        assertEquals(nomeProduto_HomePage.toUpperCase(), nomeProduto_ProdutoPage.toUpperCase());

    }
    @Test

    public void testLoginComSucesso_UsuarioLogado()  {
        loginPage = homePage.click_SingIn();
        loginPage.inserirEmail("rodrigolima.ads93@gmail.com");
        loginPage.inserirSenha("psw123");
        HomePage homePage =  loginPage.fazerLogin();
        String usuarioLogado = homePage.estaLogado();
        assertThat(usuarioLogado,is("Rodrigo Lima"));
        assertThat(homePage.estaLogado2("Rodrigo Lima"), is(true));
        carregarPaginaInicial();
    }

    @Test
    public void testeIncluirProdutoNoCarrinho_ProdutoInclusoComSucesso() throws InterruptedException {
        //Pré-condicao : usuario logado
        if(!homePage.estaLogado2("Rodrigo Lima")){
            testLoginComSucesso_UsuarioLogado();
        }
        //Teste : selecionando produto
        testValidarDetalhesDoProduto_DescriscaoEValorIguais();

        //selecionar tamanho
        produtoPage.selecionarOpcaoDropDrown(tamanhoProduto);
        List<String> listaOpcoes = produtoPage.obterOpcoesSelecionadas();

        //selecionar cor
        produtoPage.selecionarCorPreta();

        //selecionar quantidade
        produtoPage.informarQuantidade(quantidadeProduto);
        //adicionar no carrinho
        modalProdutoPage = produtoPage.click_addtocart();

        //validaçoes
        assertTrue(modalProdutoPage.validarMensagemProdutoAdicionado().endsWith("Product successfully added to your shopping cart"));
        assertEquals(modalProdutoPage.obterQuantidadeProduto(), Integer.toString(quantidadeProduto));
        assertEquals(modalProdutoPage.obterCorProduto(),corProduto);
        assertEquals(modalProdutoPage.obterTamanhoProduto(),tamanhoProduto);
        assertEquals(modalProdutoPage.obterDescricaoProduto().toUpperCase(),produtoPage.obterNomeProduto());

    }
    @Test
    public void testAdicionarProdutoNoCarrinho_and_RemoverProdutoDoCarrinho() throws InterruptedException {
        produtoPage = homePage.clicarNoProduto(0);
        produtoPage.informarQuantidade(3);
        modalProdutoPage = produtoPage.click_addtocart();
        produtoPage = modalProdutoPage.continuarComprando();
        homePage = produtoPage.paginaInicial();
        carrinhoPage = homePage.visualizarCarrinho();
        carrinhoPage.removerProdutoDoCarrinho(0);
        assertEquals(produtoPage.obterQuantidadeDeProdutosNoCarrinho(),"(0)");

    }
@Test
    public void testCalcularSomarDosProdutos_3Itens() throws InterruptedException {
    produtoPage = homePage.clicarNoProduto(0);
    produtoPage.informarQuantidade(3);
    modalProdutoPage = produtoPage.click_addtocart();
    produtoPage = modalProdutoPage.continuarComprando();
    Thread.sleep(2000);
    homePage = produtoPage.paginaInicial();
    carrinhoPage = homePage.visualizarCarrinho();
    double totalProdutos = Double.parseDouble(carrinhoPage.obterPrecoProduto()) * Integer.parseInt(carrinhoPage.obterQuantidadeProduto());
    assertThat(totalProdutos,is(57.36));
}

}