package com.epam.lab.accounts.e2e.config;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Supplier;

public class PageElementCollection {

    public static PageElementCollection of(Supplier<List<WebElement>> webElementListSupplier) {
        final PageElementCollection pageElementCollection = new PageElementCollection();
        pageElementCollection.set(webElementListSupplier);
        return pageElementCollection;
    }

    public Supplier<List<WebElement>> webElementListSupplier;

    public void set(Supplier<List<WebElement>> webElementListSupplier) {
        this.webElementListSupplier = webElementListSupplier;
    }
}
