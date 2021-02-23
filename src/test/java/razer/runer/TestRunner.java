package razer.runer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "razer/steps",
    plugin = {
      "pretty:target/cucumber-pretty.txt",
      "html:target/cucumber-html-report",
      "json:target/cucumber.json",
      "rerun:target/rerun.txt"
    },
    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {}
