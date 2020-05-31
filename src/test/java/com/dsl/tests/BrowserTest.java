package com.dsl.tests;

import com.dsl.webdriverProxy.driverManager.browsers.ChromeDriverManager;
import com.dsl.webdriverProxy.driverManager.browsers.FirefoxDriverManager;
import com.dsl.webdriverProxy.driverManager.browsers.ProxyBrowser;
import org.testng.annotations.Test;

public class BrowserTest {

    public ProxyBrowser proxyBrowser;

    @Test
    public void validateChromeBrowserLaunchActivity() {
        proxyBrowser = new ProxyBrowser(new ChromeDriverManager());
        proxyBrowser.getDriver();
        proxyBrowser.terminateDriver();
    }

    @Test
    public void validateFireFoxBrowserLaunchActivity() {
        proxyBrowser = new ProxyBrowser(new FirefoxDriverManager());
        proxyBrowser.getDriver();
        proxyBrowser.terminateDriver();
    }

}

