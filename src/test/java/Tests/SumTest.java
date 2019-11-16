package Tests;

import DataProviders.SumTestDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends BaseTest {
    @Test(dataProviderClass = SumTestDataProvider.class,
            dataProvider = "Sum Data Provider" , groups = "Group_1")
    public void sumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
