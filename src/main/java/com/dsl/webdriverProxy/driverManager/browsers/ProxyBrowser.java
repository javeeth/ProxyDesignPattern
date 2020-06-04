package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.IDriver;
import com.dsl.webdriverProxy.exception.BlockedSiteException;
import com.dsl.webdriverProxy.exception.UnsupportedBrowserException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ProxyBrowser implements IDriver {

    private IDriver driver;

    public ProxyBrowser(String browseName){
        this.driver = getBrowser(browseName);
    }


    @Override
    public WebDriver getDriver() {
        return driver.getDriver();
    }

    @Override
    public void navigateToUrl(String url) {
        if(getBlockedSites().contains(url)){
            throw new BlockedSiteException(url);
        }
        driver.navigateToUrl(url);
    }

    @Override
    public void terminateDriver() {
        if(driver != null)
            driver.terminateDriver();
    }


    private IDriver getBrowser(String browserName){
        switch (browserName) {
            case "CHROME" :
                return new ChromeDriverManager();
            case "FIREFOX":
                return new FirefoxDriverManager();
            default:
                throw new UnsupportedBrowserException(browserName);
        }
    }

    private List<String> getBlockedSites(){
        List<String> blockedSites = new ArrayList<>();
        blockedSites.add("https://www.youtube.com/");

        return blockedSites;
    }
}
