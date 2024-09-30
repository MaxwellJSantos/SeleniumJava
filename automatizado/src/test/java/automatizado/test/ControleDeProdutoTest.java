package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;
    
@BeforeClass
public static void prepararTestes(){
    loginPage = new LoginPO(driver);
    loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");

    controleProdutoPage = new ControleDeProdutoPO(driver);
    assertEquals(controleProdutoPage.obterTituloPagina(),"Controle de Produtos");
}   

@Test
public void TC001_deveAbrirModalParaCadatroAoClicarNoBotaoCriar(){
    
    controleProdutoPage.buttonAdicionar.click();
    //TODO: Remover esse clique assim que o sistema for corrigido.
    controleProdutoPage.buttonAdicionar.click();

    String titulo = controleProdutoPage.tituloModal.getText();

    assertEquals("Produto", titulo);

    controleProdutoPage.buttonSair.click();
    controleProdutoPage.buttonSair.click();

}

// @Test
// public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){

//     controleProdutoPage.buttonAdicionar.click();
//     controleProdutoPage.buttonAdicionar.click(); 

//     controleProdutoPage.cadastrarProduto("00001", "martelo", 10, 59.9, "");

//     //Aqui vamos capturar a mensagem de erro
//     String mensagem = controleProdutoPage.spanMensagem.getText();

//     assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
// }

@Test
public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){

    String mensagem = "Todos os campos são obrigatórios para o cadastro!";
    controleProdutoPage.buttonAdicionar.click();
  //controleProdutoPage.buttonAdicionar.click(); 

//Aqui cria o objeto para adicionar na tela.
   ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

//Aqui estamos testando se o produto é adicionado sem código
produtoBuilder
.adicionarCodigo("")
.builder();

assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

//Aqui estamos testeando se o produto é adicionado sem a quantidade
produtoBuilder
.adicionarCodigo("00005")
.adicionarQuantidade(null)
.builder();

assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

//Aqui estamos testando se o produto é adicionado sem nome 
produtoBuilder
.adicionarQuantidade(15)
.adicionarNome("")
.builder();

assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

//Aqui estamos testando se o produto é adicionado sem valor
produtoBuilder
.adicionarNome("Cimento")
.adicionarValor(null)
.builder();

assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

//Aqui estamos testando se o produto é adicionado sem data
produtoBuilder
.adicionarNome("Cimento")
.adicionarValor(50.0)
.adicionarData("")
.builder();

assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

    //Aqui vamos capturar a mensagem de erro
   // String mensagem = controleProdutoPage.spanMensagem.getText();

}

}
