package StepDefinitions;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchTestResult {
    @Given("Navigate to the page")
    public void navigateToThePage() {
        ParameterDriver.getDriver().get("https://www.snapdeal.com");
    }

    @When("User type {string} into the search box")
    public void userTypeIntoTheSearchBox(String string) {
        WebElement searchInbox = ParameterDriver.getDriver().findElement(By.cssSelector("input[id='inputValEnter']"));
        searchInbox.sendKeys(string);
    }

    @And("Click on the search button")
    public void clickOnTheSearchButton() {
        WebElement searchButton = ParameterDriver.getDriver().findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
        searchButton.click();
    }

    @Then("Results are displayed")
    public void isDisplayed() {
        WebElement textResult = ParameterDriver.getDriver().findElement(By.xpath("//div[@id='searchMessageContainer']//div//span[contains(text(),'results')]"));
        Assert.assertTrue(textResult.isDisplayed());
        Assert.assertTrue(textResult.getText().contains("results"));
    }
}
