package jm.tests.logistics;

import java.util.List;

/**
 * Инструкция содержащая информацию о товарах для погрузки.
 */
public class Instruction {
    private final List<Item> items;

    public Instruction(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        int totalCost = 0;
        StringBuilder builder = new StringBuilder();
        for (Item sh : items) {
            builder.append(sh.getName());
            builder.append(" ");
            totalCost += sh.getCost();
        }
        builder.append(totalCost);
        return builder.toString();
    }
}
