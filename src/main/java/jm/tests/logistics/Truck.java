package jm.tests.logistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Машина для перевозки товаров.
 */
public class Truck {
    private final List<Item> items = new ArrayList<>();
    private final int loadCapacity;
    private int freeCapacity;

    public Truck(int loadCapacity) {
        this.loadCapacity = loadCapacity;
        freeCapacity = loadCapacity;
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

    public int getLoadCapacity() {
        return loadCapacity;
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
