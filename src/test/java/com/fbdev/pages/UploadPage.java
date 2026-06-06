package com.fbdev.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class UploadPage {

    private final Page page;
    private static final String URL = "https://the-internet.herokuapp.com/upload";
    private final Locator selectFileToUpload;
    private final Locator uploadButton;
    private final Locator successMessage;

    public UploadPage(Page page) {
        this.page = page;
        this.selectFileToUpload = page.locator("#file-upload");
        this.uploadButton = page.locator("input[value='Upload']");
        this.successMessage = page.locator("h3");
    }

    public void navigate(){
        page.navigate(URL);
    }

    public void selectFile(String fileName) {
        selectFileToUpload.setInputFiles(Paths.get("src/test/resources/files/" + fileName));
    }

    public String getFileName() {
        String fullPath = selectFileToUpload.inputValue();
        return fullPath.substring(fullPath.lastIndexOf("\\") + 1);
    }

    public void uploadFile() {
        uploadButton.click();
    }

    public boolean isUploadSuccessful() {
        return "File Uploaded!".equals(successMessage.textContent());
    }

}
