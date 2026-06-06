package com.fbdev.runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = "cucumber.glue",
        value = "com.fbdev.steps"
)
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "pretty, html:target/cucumber-report.html"
)
public class TestRunner {
}
