package com.fbdev.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DynamicControlsPage {

    private final Page page;
    private final Locator checkbox;
    private final Locator removeButton;
    private final Locator addButton;
    private final Locator enableButton;
    private final Locator disableButton;
    private final Locator text;
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_controls";

    public DynamicControlsPage(Page page) {
        this.page = page;
        this.checkbox = page.locator("#checkbox");
        this.removeButton = page.locator("button:has-text('Remove')");
        this.addButton = page.locator("button:has-text('Add')");
        this.enableButton = page.locator("button:has-text('Enable')");
        this.disableButton = page.locator("button:has-text('Disable')");
        this.text = page.locator("input[type='text']");
    }

    public void navigate() {
        page.navigate(URL);
    }

    public void clickCheckbox() {
        checkbox.click();
    }

    public boolean isCheckboxChecked() {
        return checkbox.isChecked();
    }

    public void removeCheckbox() {
        removeButton.click();
        removeButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN)
        );
    }

    public void addCheckbox() {
        addButton.click();
        removeButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void enableText() {
        enableButton.click();
        disableButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void disableText() {
        disableButton.click();
        enableButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public boolean isCheckboxPresent() {
        return checkbox.isVisible();
    }

    public boolean isEnableButtonVisible() {
        return enableButton.isVisible();
    }

    public boolean isDisableButtonVisible() {
        return disableButton.isVisible();
    }

    public boolean isTextDisabled() {
        return text.isDisabled();
    }

}
