package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.WebDriverSingleton.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        WebDriverSingleton.INSTANCE.setDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().close();
    }
}
