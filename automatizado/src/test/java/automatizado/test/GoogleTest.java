package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {

private static GooglePO googlePage;

@BeforeClass
public static void prepararTestes(){
   driver.get("https://www.google.com/");
   googlePage = new GooglePO(driver);
}    

@Test
public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita(){

/*Tem que ser o primeiro a funcionar na página */
//WebElement rejeitarAcion = driver.findElement(By.id("W0wltc"));
//(Atenção) Não mexer (Atenção)
//googlePage.rejeitarAcao.sendKeys(Keys.ENTER);

//WebElement inputPesquisa = driver.findElement(By.name("q"));
googlePage.pesquisar("Batata frita");

String resultado = googlePage.obterResultadoDaPesquisa();

assertTrue(resultado, resultado.contains("Resultados "));

}

@Test
public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella(){

//(Atenção) Não mexer (Atenção)
googlePage.rejeitarAcao.sendKeys(Keys.ENTER);

//WebElement inputPesquisa = driver.findElement(By.name("q"));
googlePage.pesquisar("hamburguer");

String resultado = googlePage.obterResultadoDaPesquisa();

assertTrue(resultado, resultado.contains("Resultados "));

}



}
