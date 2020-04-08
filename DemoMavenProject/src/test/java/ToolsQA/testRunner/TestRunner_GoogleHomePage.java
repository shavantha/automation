package ToolsQA.testRunner;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(format={"pretty","json:target/"},glue = {"ToolsQA.stepdefs"}, features = {"/Users/shavanthaweerasinghe/projects/training/DemoMavenProject/src/test/java/ToolsQA/resource/features/"})
    public class TestRunner_GoogleHomePage {

    }

