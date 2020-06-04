package com.dsl.webdriverProxy.abstraction;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    void terminateDriver();
    WebDriver getDriver();
    void navigateToUrl(String url);
}
