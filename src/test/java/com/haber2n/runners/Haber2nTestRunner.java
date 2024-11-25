package com.haber2n.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/reports/html/cucumber-2nhaber_reports.html",
                "json:target/reports/json/json-reports/cucumber.json",
                "junit:target/reports/xml/xml-report/cucumber.xml",
                "rerun:target/reports/rerun.txt"
        },
        features = "src/test/resources/features/haber2n",
        glue = "com.haber2n.stepDefinitions",
        tags = "@2NHABER",
        dryRun = false
)
public class Haber2nTestRunner {
}
