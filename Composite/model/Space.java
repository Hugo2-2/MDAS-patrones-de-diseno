package Composite.model;

import java.util.List;

public class Space extends Consumer {
    private List<Consumer> children;

    public Space(List<Consumer> children) {
        this.children = children;
    }

    @Override
    public double calcExpenses() {
        double totalExpenses = 0;
        for (Consumer child : children) {
            totalExpenses += child.calcExpenses();
        }
        return totalExpenses;
    }
}
