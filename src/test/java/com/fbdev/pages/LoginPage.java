package com.fbdev.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private static final String URL = "https://the-internet.herokuapp.com/login";
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator successMessage;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#username");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("button[type='submit']");
        this.successMessage = page.locator(".flash.success");
        this.errorMessage = page.locator(".flash.error");
    }

    public void navigate() {
        page.navigate(URL);
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        return successMessage.isVisible();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isVisible();
    }
}
