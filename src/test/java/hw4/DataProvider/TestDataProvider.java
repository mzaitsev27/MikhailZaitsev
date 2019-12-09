package hw4.DataProvider;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestDataProvider {

    @DataProvider(name = "Data Provider")
    public Object[][] DataProvider() {
        return new Object[][]{
                {null, new Elements(Arrays.asList("Earth")).getElements(),
                        new Colors("Yellow").getColor(),
                        new Metals("Gold").getMetal(),
                        new Vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).getVegetables()},
                {new Summary(Arrays.asList(3, 8)).getSummary(),
                        null,
                        null,
                        null,
                        new Vegetables(Arrays.asList("Cucumber", "Tomato")).getVegetables()},
                {new Summary(Arrays.asList(3, 2)).getSummary(),
                        new Elements(Arrays.asList("Wind", "Fire", "Water")).getElements(),
                        null,
                        new Metals("Bronze").getMetal(),
                        new Vegetables(Arrays.asList("Onion")).getVegetables()},
                {new Summary(Arrays.asList(6, 5)).getSummary(),
                        new Elements(Arrays.asList("Water")).getElements(),
                        new Colors("Green").getColor(),
                        new Metals("Selen").getMetal(),
                        new Vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).getVegetables()},
                {null,
                        new Elements(Arrays.asList("Fire")).getElements(),
                        new Colors("Blue").getColor(),
                        null,
                        new Vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).getVegetables()}
        };
    }
}

