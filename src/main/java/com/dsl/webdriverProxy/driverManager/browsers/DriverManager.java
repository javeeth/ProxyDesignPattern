package com.dsl.webdriverProxy.driverManager.browsers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }
}
