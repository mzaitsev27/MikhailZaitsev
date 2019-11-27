package hw2.Ex1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestEx1 {


    @Test
    public void ex1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://epam.github.io/JDI/index.html");

        // Assert Browser title
        assertEquals(driver.getTitle().trim(), "Home Page");
        // -----------------------------------------------------------

        // Assert User name expected "PITER CHAILOVSKII
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("epam");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();
        WebElement loginedUserName = driver.findElement(By.id("user-name"));
        assertEquals(loginedUserName.getText().trim(), "PITER CHAILOVSKII");
        // -----------------------------------------------------------

        // Assert 4 items on the header section "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        List<WebElement> elements = driver.findElements(By.tagName("li"));
        List<String> foundedElements = new ArrayList<>();
        List<String> expectedElements = new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement e = elements.get(i);
            if (e.getText().equals("HOME") || e.getText().equals("CONTACT FORM") || e.getText().equals("SERVICE") || e.getText().equals("METALS & COLORS")) {
                foundedElements.add(e.getText());
            }
        }
        assertEquals(foundedElements, expectedElements);
        // --------------------------------------------------------------------------


        // Assert 4 images and proper text below each
        ExpectedConstant ec = null;
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        List<WebElement> textUnderImages = driver.findElements(By.className("benefit-txt"));
        List<String> textUnderImagesString = new ArrayList<>();
        for (int i = 0; i < textUnderImages.size(); i++) {
            textUnderImagesString.add(textUnderImages.get(i).getText());
        }
        List<String> expected = new ArrayList<>(Arrays.asList(ec.textUnderFirstImage, ec.textUnderSecondImage, ec.textUnderThirdImage, ec.textUnderFourthImage));
        assertEquals(images.size(), 4);
        assertEquals(textUnderImagesString, expected);
        // -----------------------------------------------------------------------------------------------

        // Assert a text of the main headers
        String mainHeader = driver.findElement(By.name("main-title")).getText();
        String mainHeaderText = driver.findElement(By.name("jdi-text")).getText();
        assertEquals(mainHeader, ec.mainHeader);
        assertEquals(mainHeaderText, ec.mainHeaderText);
        // ---------------------------------------------


        // Assert iframe
        WebElement frame = driver.findElement(By.id("iframe"));
        assertTrue(frame.isDisplayed());
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.xpath(".//*[@id = 'epam_logo']")).isDisplayed()) ;
        // --------------------------------------------------------

        // Assert subheader
        List<WebElement> subHeader = driver.findElements(By.tagName("a"));
        for (int i = 0; i < subHeader.size(); i++) {
            if (subHeader.get(i).getText().equals("JDI GITHUB")) {
                assertEquals(subHeader.get(i).getText(), "JDI GITHUB");
                assertEquals(subHeader.get(i).getAttribute("href"), "https://github.com/epam/JDI");
            }
        }
        // --------------------------------------------------------------------------

        // Assert left section
        WebElement section = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(section.isDisplayed());
        // ----------------------------------------------------------------------

        // Assert footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        assertTrue(footer.isDisplayed());
        // ----------------------------------------------------

        driver.close();
    }
}

