package com.app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        dryRun = false,
        glue = {"com.app"},
        features = "classpath:features")
public class TestRunner {
}
