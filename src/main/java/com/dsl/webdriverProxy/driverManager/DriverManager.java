package com.dsl.webdriverProxy.driverManager;

import org.openqa.selenium.WebDriver;
import java.rmi.*;

public class DriverManager {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }
}
