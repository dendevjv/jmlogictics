package jm.tests.logistics;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Представляет список предметов.
 * Используется в {@link ItemSelectorByCombination}.
 */
class Items implements Cloneable {
    private ArrayList<Item> list = new ArrayList<>();

    Items() {
    }

    @SuppressWarnings("unchecked")
    private Items(ArrayList<Item> list) {
        this.list = (ArrayList<Item>) list.clone();
    }

    public List<Item> getList() {
        return list;
    }

    public void set(int i, Item item) {
        if (i < list.size()) {
            list.set(i, item);
        } else {
            list.add(item);
        }
    }

    public int cost() {
        int total = 0;
        for (Item item : list) {
            total += item.getCost();
        }
        return total;
    }

    public int weight() {
        int total = 0;
        for (Item item : list) {
            total += item.getWeight();
        }
        return total;
    }

    @Override
    public Object clone() {
        return new Items(this.list);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("; ", "[", "]");
        list.forEach(i -> joiner.add(i.toString()));
        joiner.add(Integer.toString(weight()));
        return joiner.toString();
    }
}
