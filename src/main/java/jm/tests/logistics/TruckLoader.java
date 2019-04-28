package jm.tests.logistics;

import java.util.List;

/**
 * Загрузчик машины для перевозки товаров.
 */
public class TruckLoader {
    private final ItemSelector selector;

    public TruckLoader(ItemSelector selector) {
        this.selector = selector;
    }

    public void load(Truck truck, List<Item> items) {
        List<Item> selected = selector.select(truck.getLoadCapacity(), items);
        selected.forEach(truck::add);
    }
}
