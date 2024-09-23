package com.skm.regressionsuite.utils;

import com.skm.regressionsuite.context.ApplicationContext;
import com.skm.regressionsuite.context.FeatureContext;
import com.skm.regressionsuite.context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;

import javax.inject.Inject;

public class Hooks {

    private ApplicationContext applicationContext;
    private FeatureContext featureContext;
    private ScenarioContext scenarioContext;
    
    private ExtentReports extent;
    private ExtentTest test;

    @Inject
    public Hooks(ApplicationContext applicationContext, FeatureContext featureContext, ScenarioContext scenarioContext) {
        this.applicationContext = applicationContext;
        this.featureContext = featureContext;
        this.scenarioContext = scenarioContext;
    }

    @Before(order = 0)
    public void initializeGlobalContext(Scenario scenario) {
    	
    	   // Set up Extent Report
        extent = ExtentReportManager.getInstance();
        test = extent.createTest(scenario.getName());

        
        // Initialize global application context (e.g., WebDriver)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Store WebDriver in ApplicationContext
        applicationContext.setContext("driver", driver);
    }


    @After(order = 0)
    public void tearDown(Scenario scenario) {
    	 // Log status in Extent Report
        if (scenario.isFailed()) {
            test.fail("Test Failed: " + scenario.getName());
        } else {
            test.pass("Test Passed: " + scenario.getName());
        }
        // Tear down WebDriver from ApplicationContext
        WebDriver driver = applicationContext.getContext("driver", WebDriver.class);
        if (driver != null) {
            driver.quit();
        }
        
        // Flush Extent Reports
        extent.flush();
    }

    @After(order = 1)
    public void afterScenario() {
        // Clear scenario-level data
        scenarioContext = new ScenarioContext(); // Reset scenario context
    }

    @After(order = 2)
    public void afterFeature() {
        // Clear feature-level data
        featureContext = new FeatureContext(); // Reset feature context
    }
}
