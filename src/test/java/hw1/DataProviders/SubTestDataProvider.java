package DataProviders;

import org.testng.annotations.DataProvider;

public class SubTestDataProvider {

    @DataProvider(name = "Sub Data Provider")
    public Object[][] subTestDataProvider() {
        return new Object[][]{
                {2, 2, 0},
                {3, 5, -2},
                {7, 10, -3}
        };
    }
}
