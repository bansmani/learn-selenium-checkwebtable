import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    monochrome = true,
    features = ["classpath:features"],
    glue = ["example"],
    plugin =
    ["pretty", "html:target/cucumber-reports",
        "json:target/cucumber.json"]
)
class Runner