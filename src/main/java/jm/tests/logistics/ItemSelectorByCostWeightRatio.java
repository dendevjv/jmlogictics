package jm.tests.logistics;

import java.util.*;

/**
 * Выбирает предметы для погрузки в порядке уменьшения их стоимости.
 */
public class ItemSelectorByCostWeightRatio implements ItemSelector {
    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * Отбор производится в порядке уменьшения соотношения стоимости и веса предметов.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param items список предметов
     * @return список предметов отобранных для погрузки.
     */
    @Override
    public List<Item> select(int loadCapacity, List<Item> items) {
        List<Item> result = new ArrayList<>();
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort((first, second) -> Double.compare(
                second.costToWeightRatio(),
                first.costToWeightRatio())
        );
        int totalLoad = 0;
        for (Item item : sorted) {
            if (totalLoad + item.getWeight() <= loadCapacity) {
                result.add(item);
                totalLoad += item.getWeight();
            }
        }
        return result;
    }
}
