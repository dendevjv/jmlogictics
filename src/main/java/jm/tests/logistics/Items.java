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

    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        try {
            Items it = (Items) super.clone();
            it.list = (ArrayList<Item>) this.list.clone();
            return it;
        } catch (CloneNotSupportedException e) {
            // этого не должны произойти, так как класс Cloneable
            throw new InternalError(e);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("; ", "[", "]");
        list.forEach(i -> joiner.add(i.toString()));
        joiner.add(Integer.toString(weight()));
        return joiner.toString();
    }
}
