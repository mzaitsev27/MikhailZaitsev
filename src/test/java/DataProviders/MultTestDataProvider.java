package DataProviders;

import org.testng.annotations.DataProvider;

public class MultTestDataProvider {

    @DataProvider(name = "Mult Data Provider")
    public Object[][] MultTestDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {3, 5, 15},
                {7, 10, 70}
        };
    }
}
