package hw5;

import org.openqa.selenium.WebDriver;

public enum WebDriverSingleton {

    INSTANCE;

    public WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}