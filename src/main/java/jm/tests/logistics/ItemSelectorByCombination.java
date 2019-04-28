package jm.tests.logistics;

import java.util.*;

/**
 * Выбирает предметы для погрузки используя для выбора
 * перебор всех возможных комбинаций.
 */
public class ItemSelectorByCombination implements ItemSelector {
    private List<Items> combinations;

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
        generateCombinations(source);
        return combinations.stream()
                .filter(items -> items.weight() <= loadCapacity)
                .max(Comparator.comparingInt(Items::cost))
                .orElseThrow().getList();
    }

    private void generateCombinations(List<Item> source) {
        combinations = new ArrayList<>();
        for (int size = 1; size <= source.size(); size++) {
            helper(source, new Items(), size, 0, 0);
        }
    }

    private void helper(List<Item> source, Items buffer, int limit, int sourceIdx, int bufferIdx) {
        if (bufferIdx == limit) {
            combinations.add((Items) buffer.clone());
        } else if (sourceIdx < source.size()) {
            Item item = source.get(sourceIdx);
            buffer.set(bufferIdx, item);
            helper(source, buffer, limit, sourceIdx + 1, bufferIdx + 1);
            helper(source, buffer, limit, sourceIdx + 1, bufferIdx);
        }
    }
}
