package com.dsl.webdriverProxy.driverManager.browsers;

import com.dsl.webdriverProxy.abstraction.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager implements Driver {

    public ChromeDriverManager(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }
}
