package com.epam.lab.accounts.e2e.config;

import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class PageElement {

    public static PageElement of(Supplier<WebElement> webElementSupplier) {
        final PageElement pageElement=new PageElement();
        pageElement.set(webElementSupplier);
        return pageElement;
    }
    private Supplier<WebElement> webElementSupplier;

    public void set(Supplier<WebElement> webElementSupplier) {
        this.webElementSupplier = webElementSupplier;
    }

    private WebElement get() {
        return webElementSupplier.get();
    }

    public void sendKeys(String text) {
        get().clear();
        get().sendKeys(text);
    }

    public void submit() {
        get().submit();
    }

    public void click() {
        get().click();
    }

    public void clear() {
        get().clear();
    }

    public String getText() {
        return get().getText();
    }
}
