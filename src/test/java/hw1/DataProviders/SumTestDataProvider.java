package DataProviders;

import org.testng.annotations.DataProvider;

public class SumTestDataProvider {

    @DataProvider(name = "Sum Data Provider")
    public Object[][] sumTestDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {3, 5, 8},
                {7, 10, 17}
        };
    }
}
