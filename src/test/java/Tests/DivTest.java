package Tests;

import DataProviders.DivTestDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivTest extends BaseTest {
    @Test(dataProviderClass = DivTestDataProvider.class,
            dataProvider = "Div Data Provider", groups = "Group_2")
    public void divTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
