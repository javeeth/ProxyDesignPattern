package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.IDriver;
import com.dsl.webdriverProxy.driverManager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager implements IDriver {

    public ChromeDriverManager(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
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
