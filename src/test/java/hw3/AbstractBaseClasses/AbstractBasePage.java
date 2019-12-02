package hw3.AbstractBaseClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void headerMenuItemClick(final String menuItemName) {
        driver.findElement(By.linkText(menuItemName)).click();
    }

    public List<String> headerMenuServiceItems() {
        List<WebElement> headerMenuServiceItems = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        List<String> headerMenuServiceItemsString = new ArrayList<>();
        for (int i =  0 ; i <  headerMenuServiceItems.size() ; i++) {
            headerMenuServiceItemsString.add(headerMenuServiceItems.get(i).getText());
        }
        return headerMenuServiceItemsString;
    }

    public void headerMenuServiceItemClick (final String serviceItemName) {
        driver.findElement(By.linkText(serviceItemName)).click();
    }

    public WebElement getLeftSection () {
        return driver.findElement(By.id("mCSB_1"));
    }

    public void leftSectionMenuItemClick(final String dropdownItemName) {
        driver.findElement(By.linkText(dropdownItemName)).click();
    }

    public List<String> leftSectionMenuServiceItems() {
        List<WebElement> leftSectionMenuServiceItems = driver.findElements(By.xpath("//ul[@class = 'sub']/li"));
        List<String> leftSectionMenuServiceItemsString = new ArrayList<>();
        for (int i =  0 ; i <  leftSectionMenuServiceItems.size() ; i++) {
            leftSectionMenuServiceItemsString.add(leftSectionMenuServiceItems.get(i).getText());
        }
        return leftSectionMenuServiceItemsString;
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
}
