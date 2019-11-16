package DataProviders;

import org.testng.annotations.DataProvider;

public class DivTestDataProvider {

    @DataProvider(name = "Div Data Provider")
    public Object[][] DivTestDataProvider() {
        return new Object[][]{
                {2, 2, 1},
                {10, 5, 2},
                {66, 11, 6}
        };
    }
}
