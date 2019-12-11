package hw4.DataProvider;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestDataProvider {

    @DataProvider(name = "Data Provider")
    public Object[][] DataProvider() {
        return new Object[][]{
                {null, Arrays.asList("Earth"), "Yellow", "Gold", Arrays.asList("Cucumber", "Tomato", "Vegetables")},
                {Arrays.asList(3, 8), null, null, null, Arrays.asList("Cucumber", "Tomato")},
                {Arrays.asList(3, 2), Arrays.asList("Wind", "Fire", "Water"), null, "Bronze", Arrays.asList("Onion")},
                {Arrays.asList(6, 5), Arrays.asList("Water"), "Green", "Selen",
                        Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")},
                {null, Arrays.asList("Fire"), "Blue", null, Arrays.asList("Cucumber", "Tomato", "Vegetables")}


        };
    }


}

