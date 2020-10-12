package example


import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver


class TestClass {

    companion object {
        private lateinit var driver: WebDriver;
        private lateinit var tableColMap: List<String>

    }


    @Given("launch application")
    fun launch() {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver.get("https://purecss.io/tables/")

        val table = driver.findElement(By.className("pure-table"))
        val cols = table.findElements(By.xpath("thead/tr/th"))
        tableColMap = cols.map { webElement -> webElement.text }.toList()

    }

    @Then("webtable at row {int} and column {string} should have value {string}")
    fun webtable_at_row_and_column_should_have_value_honda(rowid: Int?, column: String?, myval: String?) {

        val colid = tableColMap.indexOf(column) + 1
        val table = driver.findElement(By.className("pure-table"))
        val text = table.findElement(By.xpath("tbody/tr[$rowid]/td[$colid]"))?.text

        Assertions.assertEquals(myval, text, "comparing data at Row: $rowid, Column: $column")
//        println("$rowid - $column - $myval | $text")

    }


}