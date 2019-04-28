package jm.tests.logistics;

import java.util.List;

public interface ItemSelector {
    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param source список предметов
     * @return список предметов отобранных для погрузки.
     */
    List<Item> select(int loadCapacity, List<Item> source);
}
