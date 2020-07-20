package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true
        ,features = "./src/main/resources/features"
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,glue = {"steps/"}
        ,monochrome = true
        ,plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.jon","junit:target/cucumber.xml"}
        ,tags ="@listaProdutos" //{"@realizarBusca, @AddCarrinho"}


)
public class Runner {
}
