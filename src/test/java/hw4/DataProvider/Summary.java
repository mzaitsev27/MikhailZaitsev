package hw4.DataProvider;

import java.util.List;

public class Summary {
    private List<Integer> summary;

    public Summary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }
}
