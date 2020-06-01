package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.Driver;
import com.dsl.webdriverProxy.exception.UnsupportedBrowserException;
import org.openqa.selenium.WebDriver;

public class ProxyBrowser implements Driver {

    private Driver driver;

    public ProxyBrowser(String browseName){
        this.driver = getBrowser(browseName);
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


    private Driver getBrowser(String browserName){
        switch (browserName) {
            case "CHROME" :
                return new ChromeDriverManager();
            case "FIREFOX":
                return new FirefoxDriverManager();
            default:
                throw new UnsupportedBrowserException(browserName);
        }
    }
}
