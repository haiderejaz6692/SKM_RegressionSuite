package com.skm.regressionsuite.stepdefinitions;

import com.skm.regressionsuite.context.ApplicationContext;
import com.skm.regressionsuite.context.FeatureContext;
import com.skm.regressionsuite.context.ScenarioContext;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public class BaseSteps {

    protected ApplicationContext applicationContext;
    protected FeatureContext featureContext;
    protected ScenarioContext scenarioContext;

    @Inject
    public BaseSteps(ApplicationContext applicationContext, FeatureContext featureContext, ScenarioContext scenarioContext) {
        this.applicationContext = applicationContext;
        this.featureContext = featureContext;
        this.scenarioContext = scenarioContext;
    }
    
    @Inject
    public BaseSteps(ApplicationContext applicationContext, FeatureContext featureContext) {
        this.applicationContext = applicationContext;
        this.featureContext = featureContext;
    }

    @Inject
    public BaseSteps(ApplicationContext applicationContext, ScenarioContext scenarioContext) {
        this.applicationContext = applicationContext;
        this.scenarioContext = scenarioContext;
    }
    
    @Inject
    public BaseSteps(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    public BaseSteps() {
    	
    }
    
    // Get WebDriver from ApplicationContext
    public WebDriver getDriver() {
        return applicationContext.getContext("driver", WebDriver.class);
    }

    // Feature-level context access
    public Object getFeatureContext(String key) {
        return featureContext.getContext(key);
    }

    public void setFeatureContext(String key, Object value) {
        featureContext.setContext(key, value);
    }

    // Scenario-level context access
    public Object getScenarioContext(String key) {
        return scenarioContext.getContext(key);
    }

    public void setScenarioContext(String key, Object value) {
        scenarioContext.setContext(key, value);
    }
}
