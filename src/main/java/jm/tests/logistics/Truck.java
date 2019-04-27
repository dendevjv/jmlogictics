package jm.tests.logistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Машина для перевозки товаров.
 */
public class Truck {
    private final List<Item> items = new ArrayList<>();
    private final int carryingCapacity;
    private int freeCapacity;

    public Truck(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
        freeCapacity = carryingCapacity;
    }

    public boolean canCarry(Item item) {
        return item.getWeight() <= freeCapacity;
    }

    public boolean add(Item item) {
        if (canCarry(item)) {
            items.add(item);
            freeCapacity -= item.getWeight();
            return true;
        }
        return false;
    }

    public int getFreeCapacity() {
        return freeCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public String itemsDescription() {
        int totalCost = 0;
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            builder.append(item.getName());
            builder.append(" ");
            totalCost += item.getCost();
        }
        builder.append(totalCost);
        return builder.toString();
    }
}
