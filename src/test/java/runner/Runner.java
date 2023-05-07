package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"html:target/cucumber_html_report.html","pretty"},
monochrome=true,
features="src/test/java/features",
glue="stepdefinations"
)
public class Runner extends AbstractTestNGCucumberTests{


}
