package com.fbdev.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FormPage {

    private final Page page;

    private static final String URL = "https://the-internet.herokuapp.com/forgot_password";
    private final Locator emailInput;
    private final Locator submitButton;
    private final Locator successMessage;

    public FormPage(Page page) {
        this.page = page;
        this.emailInput = page.locator("#email");
        this.submitButton = page.locator("button[type='submit']");
        this.successMessage = page.locator("h1");
    }

    public void navigate() {
        page.navigate(URL);
    }

    public void submitEmail(String email) {
        emailInput.fill(email);
        submitButton.click();
    }

    public String getConfirmationMessage() {
        return successMessage.textContent();
    }
}
