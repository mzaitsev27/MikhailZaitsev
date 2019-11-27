package hw2.Ex2;

import hw2.AbstractBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestEx2 extends AbstractBaseTest {
    @Test
    public void ex2() {


        driver.get("https://epam.github.io/JDI/index.html");
        SoftAssert softAssert = new SoftAssert();

        // Assert Browser title
        assertEquals(driver.getTitle().trim(), "Home Page");
        // -----------------------------------------------------------

        // Assert User name expected "PITER CHAILOVSKII
        login();
        WebElement loginedUserName = driver.findElement(By.id("user-name"));
        assertEquals(loginedUserName.getText().trim(), "PITER CHAILOVSKII");
        // -----------------------------------------------------------


        // Assert "Service" subcategory in the header
        WebElement serviceFromHeader = driver.findElement(By.className("dropdown-toggle"));
        serviceFromHeader.click();
        softAssert.assertTrue(serviceFromHeader.isDisplayed());
        // ----------------------------------------------------------------


        // Assert "Service" subcategory in the left section
        WebElement serviceFromLeftSection = driver.findElement(By.className("menu-title"));
        serviceFromLeftSection.click();
        softAssert.assertTrue(serviceFromLeftSection.isDisplayed());
        // -----------------------------------------------------------------


        // Open Service - > Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        List<WebElement> header = driver.findElements(By.tagName("li"));
        for (int i = 0; i < header.size(); i++) {
            if (header.get(i).getText().equals("DIFFERENT ELEMENTS")) {
                header.get(i).click();
                break;
            }
        }

        // Assert 4 checkboxes at "Different Eelements" page
        List<WebElement> checkboxes = driver.findElements(By.xpath("//label[@class = 'label-checkbox']"));
        softAssert.assertEquals(checkboxes.size(), 4);
        for (int i = 0; i < checkboxes.size(); i++) {
            softAssert.assertTrue(checkboxes.get(i).isDisplayed());
        }


        // 4 radios
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        assertEquals(radios.size(), 4);
        for (int i = 0; i < checkboxes.size(); i++) {
            assertTrue(radios.get(i).isDisplayed());
        }

        // dropdown
        WebElement dropdown = driver.findElement(By.tagName("select"));
        assertTrue(dropdown.isDisplayed());

        // 2 buttons
        List<WebElement> buttons = driver.findElements(By.className("uui-button"));
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getAttribute("value").equals("Default Button") || buttons.get(i).getAttribute("value").equals("Button")) {
                assertTrue(buttons.get(i).isDisplayed());
            }
        }
        // --------------------------------------------------------------------------------


        // Assert that there is Right Section
        WebElement rightSideBar = driver.findElement(By.id("mCSB_2"));
        softAssert.assertTrue(rightSideBar.isDisplayed());

        // Assert that there is Left Section
        WebElement leftSideBar = driver.findElement(By.id("mCSB_1"));
        softAssert.assertTrue(leftSideBar.isDisplayed());
        // ----------------------------------------------------------------------


        // Select Water and Wind checkboxes
        WebElement waterCheckbox = driver.findElement(By.xpath("//label[@class = 'label-checkbox'][position() = 1]"));
        WebElement windCheckbox = driver.findElement(By.xpath("//label[@class = 'label-checkbox'][position() = 3]"));
        waterCheckbox.click();
        windCheckbox.click();
        // -----------------------------------------------------------------------------------------------------

        List<WebElement> logs = driver.findElements(By.xpath(".//li[contains(text(),\"changed\")]"));

        // Assert log for checkboxes
        List<WebElement> checkboxesInput = driver.findElements(By.xpath("//label[@class = 'label-checkbox']/input"));
        for (int i = 0; i < checkboxes.size(); i++) {
            for (int j = 0; j < logs.size(); j++) {
                if (logs.get(j).getText().contains(checkboxes.get(i).getText())) {
                    if (logs.get(j).getText().endsWith("true")) {
                        assertEquals(checkboxesInput.get(i).isSelected(), true);
                    } else {
                        assertEquals(checkboxesInput.get(i).isSelected(), false);
                        break;
                    }
                }
            }
        }
        // -----------------------------------------------------------------------------------


        // Select radio "Selen"
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).getText().equals("Selen")) {
                radios.get(i).click();
                WebElement newLog = driver.findElement(By.xpath(".//li[contains(text(),\"changed\")][position() =1]"));
                logs.add(newLog);
            }
        }


        // Assert log for radios
        List<WebElement> radioInput = driver.findElements(By.xpath("//label[@class = 'label-radio']/input"));
        for (int i = 0; i < radios.size(); i++) {
            for (int j = logs.size() - 1; j > 0; j--) {
                if (logs.get(j).getText().contains(radios.get(i).getText())) {
                    assertEquals(radioInput.get(i).isSelected(), true);
                } else {
                    assertEquals(radioInput.get(i).isSelected(), false);
                }
                break;
            }
        }

        // Select "Yellow" in dropdown
        dropdown.click();
        List<WebElement> colors = driver.findElements(By.tagName("option"));
        for (int i = 0; i < colors.size(); i++) {
            if (colors.get(i).getText().equals("Yellow")) {
                colors.get(i).click();
                WebElement newLog = driver.findElement(By.xpath(".//li[contains(text(),\"changed\")][position() =1]"));
                logs.add(newLog);
            }
        }

        // Assert log for color
        for (int i = 0; i < colors.size(); i++) {
            for (int j = logs.size() - 1; j > 0; j--) {
                if (logs.get(j).getText().contains(colors.get(i).getText())) {
                    softAssert.assertEquals(colors.get(i).getText(), "Yellow");
                }
                break;
            }
        }

        // Unselect checkboxes "Water" and "Wind"
        waterCheckbox.click();
        WebElement waterCheckboxLog = driver.findElement(By.xpath(".//li[contains(text(),\"changed\")][position() =1]"));
        logs.add(waterCheckboxLog);
        windCheckbox.click();
        WebElement windCheckboxLog = driver.findElement(By.xpath(".//li[contains(text(),\"changed\")][position() =1]"));
        logs.add(windCheckboxLog);

        // Assert that checkboxes "Water" and "Wind" unselected
        for (int i = 0; i < checkboxes.size(); i++) {
            for (int j = logs.size() - 1; j >= 0 ; j--) {
                if (logs.get(j).getText().contains(checkboxes.get(i).getText())) {
                    if (logs.get(j).getText().endsWith("true")) {
                        softAssert.assertEquals(checkboxesInput.get(i).isSelected(), true);
                    } else {
                        softAssert.assertEquals(checkboxesInput.get(i).isSelected(), false);
                        break;
                    }
                }
            }
        }

        softAssert.assertAll();
    }
}

