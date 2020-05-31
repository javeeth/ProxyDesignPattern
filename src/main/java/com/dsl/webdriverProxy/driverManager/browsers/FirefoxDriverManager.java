package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager implements Driver {

    public FirefoxDriverManager(){
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }
}
