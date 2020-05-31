package com.dsl.webdriverProxy.abstraction;

import org.openqa.selenium.WebDriver;

public interface Driver {
    void terminateDriver();
    WebDriver getDriver();
}
