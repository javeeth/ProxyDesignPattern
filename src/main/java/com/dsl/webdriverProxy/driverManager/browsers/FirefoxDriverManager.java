package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.IDriver;
import com.dsl.webdriverProxy.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager implements IDriver {

    public FirefoxDriverManager(){
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }

    @Override
    public void navigateToUrl(String url) {
        driver.get().get(url);
    }
}
