package jm.tests.logistics;

import java.util.List;

/**
 * Инструкция содержащая информацию о товарах для погрузки.
 */
public class Instruction {
    private final List<Shipment> shipments;
    private int totalCost;

    public Instruction(List<Shipment> shipments) {
        this.shipments = shipments;
        shipments.forEach(sh -> totalCost += sh.getCost());
    }

    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        shipments.forEach(sh -> {
            builder.append(sh.getName());
            builder.append(" ");
        });
        builder.append(totalCost);
        return builder.toString();
    }
}
