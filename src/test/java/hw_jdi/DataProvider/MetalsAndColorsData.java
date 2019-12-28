package hw_jdi.DataProvider;

import java.util.List;


public class MetalsAndColorsData {

    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "summary=" + summary +
                ", elements=" + elements +
                ", color='" + color + '\'' +
                ", metal='" + metals + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetal(String metal) {
        this.metals = metal;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}

