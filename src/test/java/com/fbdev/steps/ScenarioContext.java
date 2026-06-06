package com.fbdev.steps;

import com.microsoft.playwright.Page;

public class ScenarioContext {

    private static final ThreadLocal<Page> pageHolder = new ThreadLocal<>();

    public static void setPage(Page page) {
        pageHolder.set(page);
    }

    public static Page getPage() {
        return pageHolder.get();
    }

    public static void clear() {
        pageHolder.remove();
    }

}
