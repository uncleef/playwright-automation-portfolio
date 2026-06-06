package com.fbdev.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static Playwright playwright;
    private static Browser browser;

    @Before
    public void setup() {
        boolean headless = Boolean.parseBoolean(System.getenv().getOrDefault("HEADLESS", "false"));
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(headless)
        );
        Page page = browser.newPage();
        ScenarioContext.setPage(page);
    }

    @After
    public void teardown() {
        ScenarioContext.clear();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
