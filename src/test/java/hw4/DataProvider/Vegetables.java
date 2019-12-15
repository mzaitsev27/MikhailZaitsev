package hw4.DataProvider;

import java.util.List;

public class Vegetables {
    private List<String> vegetables;

    public Vegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
