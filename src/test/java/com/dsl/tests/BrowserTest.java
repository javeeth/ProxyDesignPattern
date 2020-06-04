package com.dsl.tests;

import com.dsl.webdriverProxy.driverManager.browsers.ChromeDriverManager;
import com.dsl.webdriverProxy.driverManager.browsers.FirefoxDriverManager;
import com.dsl.webdriverProxy.driverManager.browsers.ProxyBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserTest {

    public ProxyBrowser proxyBrowser;
    WebDriver driver;

    @Test
    public void validateChromeBrowserLaunchActivity() {
        proxyBrowser = new ProxyBrowser("CHROME");
        driver = proxyBrowser.getDriver();
        proxyBrowser.navigateToUrl("https://www.google.com");
        proxyBrowser.terminateDriver();
    }

    @Test
    public void validateFireFoxBrowserLaunchActivity() {
        proxyBrowser = new ProxyBrowser("FIREFOX");
        driver = proxyBrowser.getDriver();
        proxyBrowser.navigateToUrl("https://www.google.com");
        proxyBrowser.terminateDriver();
    }

    @Test
    public void validateInvalidBrowserException() {
        proxyBrowser = new ProxyBrowser("CHROME1");
        driver = proxyBrowser.getDriver();
        proxyBrowser.navigateToUrl("https://www.google.com/");
        proxyBrowser.terminateDriver();
    }

    @Test
    public void validateBlockedSiteException() {
        proxyBrowser = new ProxyBrowser("CHROME");
        driver = proxyBrowser.getDriver();
        proxyBrowser.navigateToUrl("https://www.youtube.com/");
        proxyBrowser.terminateDriver();
    }
}

