package jm.tests.logistics;

import java.util.*;

/**
 * Выбирает предметы для погрузки используя для выбора
 * перебор возможных комбинаций с ограничением по суммарному весу.
 */
public class ItemSelectorByCombination implements ItemSelector {
    private PriorityQueue<Items> combinations;

    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * Выбирается набор предметов общим весом не более указанной грузоподъемности
     * и с наибольшей суммарной стоимостью.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param source исходный список предметов
     * @return список предметов отобранных для погрузки.
     */
    @Override
    public List<Item> select(int loadCapacity, List<Item> source) {
        combinations = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost(), o1.cost()));
        for (int size = 1; size <= source.size(); size++) {
            combineHelper(source, new Items(), size, 0, 0, loadCapacity);
        }
        return combinations.element().getList();
    }

    private void combineHelper(List<Item> source, Items buffer, int limit, int sourceIdx, int bufferIdx,
                               int loadCapacity) {
        if (bufferIdx == limit) {
            if (buffer.weight() <= loadCapacity) {
                combinations.add((Items) buffer.clone());
            }
        } else if (sourceIdx < source.size()) {
            Item item = source.get(sourceIdx);
            if (item.getWeight() <= loadCapacity) {
                buffer.set(bufferIdx, item);
                combineHelper(source, buffer, limit, sourceIdx + 1, bufferIdx + 1, loadCapacity);
            }
            combineHelper(source, buffer, limit, sourceIdx + 1, bufferIdx, loadCapacity);
        }
    }
}
