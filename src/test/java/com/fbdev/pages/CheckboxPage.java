package com.fbdev.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckboxPage {
    private final Page page;
    private final Locator firstCheckbox;
    private final Locator secondCheckbox;
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    public CheckboxPage(Page page) {
        this.page = page;
        this.firstCheckbox = page.locator("#checkboxes input").nth(0);
        this.secondCheckbox = page.locator("#checkboxes input").nth(1);
    }

    public void navigate() {
        page.navigate(URL);
    }

    public void clickCheckbox1() {
        firstCheckbox.click();
    }

    public void clickCheckbox2() {
        secondCheckbox.click();
    }

    public boolean isFirstCheckboxChecked() {
        return firstCheckbox.isChecked();
    }

    public boolean isSecondCheckboxChecked() {
        return secondCheckbox.isChecked();
    }

}