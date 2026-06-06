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
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        ScenarioContext.setPage(page);
    }

    @After
    public void teardown() {
        ScenarioContext.clear();
        browser.close();
        playwright.close();
    }
}
