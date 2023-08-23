package Runners;

import Utilities.ParameterDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions (
        features = "src/test/java/FutureFiles/SearchResultTest.feature",
        glue = "StepDefinitions",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class SearchTestResult extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters (value = "browser")
    public void beforeClass(String browser){
        ParameterDriver.setThreadDriverName(browser);
    }
}
