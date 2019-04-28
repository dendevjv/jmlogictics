package jm.tests.logistics;

import java.util.*;

/**
 * Выбирает предметы для погрузки в порядке уменьшения их стоимости.
 *
 * Данный алгоритм не является оптимальным и в отдельных случаях может
 * давать неправильный результат.<br>
 * Например следующий ввод:<br>
 * capacity 100,
 * source items "шкаф/51/99 стул/50/50 стол/50/50",
 * вернет шкаф/51/99.
 */
public class ItemSelectorByCostWeightRatio implements ItemSelector {
    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * Отбор производится в порядке уменьшения соотношения стоимости и веса предметов.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param source список предметов
     * @return список предметов отобранных для погрузки.
     */
    @Override
    public List<Item> select(int loadCapacity, List<Item> source) {
        List<Item> result = new ArrayList<>();
        List<Item> sorted = new ArrayList<>(source);
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
