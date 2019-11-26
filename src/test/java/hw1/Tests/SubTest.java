package Tests;

import DataProviders.SubTestDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest extends BaseTest {
    @Test(dataProviderClass = SubTestDataProvider.class,
            dataProvider = "Sub Data Provider", groups = "Group_1")
    public void subTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
