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
    public void userTypeIntoTheSearchBox(String arg0) {
        WebElement searchInbox = ParameterDriver.getDriver().findElement(By.cssSelector("input[id='inputValEnter']"));
        searchInbox.sendKeys("teddy bear");
    }

    @And("Click on the search button")
    public void clickOnTheSearchButton() {
        WebElement searchButton = ParameterDriver.getDriver().findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
        searchButton.click();
    }

    @Then("{string} is displayed")
    public void isDisplayed(String arg0) {
        WebElement textResult = ParameterDriver.getDriver().findElement(By.xpath("//div[@id='searchMessageContainer']//div//span[contains(text(),'results')]"));
        Assert.assertTrue(textResult.isDisplayed());
        Assert.assertTrue(textResult.getText().contains("results"));
    }
}
