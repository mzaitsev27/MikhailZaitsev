package Tests;

import DataProviders.MultTestDataProvider;
import DataProviders.SumTestDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultTest extends BaseTest {
    @Test(dataProviderClass = MultTestDataProvider.class,
            dataProvider = "Mult Data Provider" , groups = "Group_2")
    public void multTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
