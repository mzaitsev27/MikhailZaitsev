package hw6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void headerMenuServiceClick() {
        driver.findElement(By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li[3]")).click();
    }

    public void leftSectionMenuServiceClick() {
        driver.findElement(By.xpath("//li[@class = 'menu-title'][@index ='3']")).click();
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}
