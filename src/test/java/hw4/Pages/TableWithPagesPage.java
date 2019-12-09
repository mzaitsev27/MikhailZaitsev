package hw4.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TableWithPagesPage {

    public TableWithPagesPage() {
        page(this);
    }

    @FindBy(xpath = "//div[@class = 'dataTables_info']")
    private SelenideElement showEntriesValues;

    @FindBy(id = "mCSB_1")
    private SelenideElement leftSection;

    @FindBy(id = "mCSB_2")
    private SelenideElement rightSection;

    @FindBy(xpath = "//select")
    private SelenideElement showEntries;

    @FindBy(xpath = "//select/option[2]")
    private SelenideElement tenEntries;

    @FindBy(xpath = "//ul[@class = 'panel-body-list logs']/li")
    private ElementsCollection logs;

    @FindBy(xpath = "//tbody/tr")
    private ElementsCollection amountOfEntries;

    @FindBy(xpath = "//input[@type = 'search']")
    private SelenideElement searchField;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private ElementsCollection nowColumn;

    public void showEntriesByDefaultShouldBeFive() {
        $(showEntriesValues).shouldHave(text("1 to 5"));
    }

    public void leftSectionShouldBe() {
        $(leftSection).shouldBe(Condition.visible);
    }

    public void rightSectionShouldBe() {
        $(rightSection).shouldBe(Condition.visible);
    }

    public void selectTenValueForEntries() {
        $(showEntries).click();
        $(tenEntries).click();
    }

    public void showEntriesValueShouldCorrespondWithLogs() {
        String entries = $(showEntriesValues).getText();
        for (int i = 0; i < logs.size(); i++) {
            if (entries.contains("10") && logs.get(i).getText().contains("value")) {
                $$(logs).get(i).shouldHave(text("new value=10"));
            }
        }
    }

    public void amountOfEntriesShouldBeCorrect() {
        $$(amountOfEntries).shouldHaveSize(10);
    }

    public void typeInSearchField(final String searchFieldValue) {
        $(searchField).sendKeys(searchFieldValue);
    }

    public void tableShouldContainsOnlyRecordsWithSearchValue(final String searchFieldValue) {
        for (int i = 0; i < nowColumn.size(); i++) {
            $$(nowColumn).get(i).shouldHave(text(searchFieldValue));
        }
    }


}
