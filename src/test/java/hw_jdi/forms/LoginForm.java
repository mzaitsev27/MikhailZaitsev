package hw_jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw_jdi.entities.JdiUser;


public class LoginForm extends Form<JdiUser> {
    @Css("#name")
    private TextField login;

    @Css("#password")
    private TextField password;

    @Css("#login-button")
    private Button submit;
}
