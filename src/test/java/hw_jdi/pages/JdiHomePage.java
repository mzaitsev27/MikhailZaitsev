package hw_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.entities.JdiUser;
import hw_jdi.forms.LoginForm;

public class JdiHomePage extends WebPage {

    public LoginForm loginForm;

    @Css("#user-icon")
    private Button userIcon;

    public void login(JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }
}
