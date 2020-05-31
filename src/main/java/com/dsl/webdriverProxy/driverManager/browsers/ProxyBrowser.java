package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.Driver;
import org.openqa.selenium.WebDriver;

public class ProxyBrowser implements Driver {

    private Driver driver;

    public ProxyBrowser(Driver driver){
        this.driver = driver;
    }

    @Override
    public void terminateDriver() {
        if(driver != null)
            driver.terminateDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver.getDriver();
    }
}
