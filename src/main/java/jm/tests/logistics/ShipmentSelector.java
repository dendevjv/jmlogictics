package jm.tests.logistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Выбирает предметы для погрузки в порядке уменьшения их стоимости.
 */
public class ShipmentSelector {
    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * Отбор производится в порядке уменьшения стоимости предметов.
     * Из двух предметов с одинаковой стоимостью отбирается предмет с меньшим весом.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param shipments список предметов
     * @return список предметов отобранных для погрузки.
     */
    public List<Shipment> select(int loadCapacity, List<Shipment> shipments) {
        List<Shipment> result = new ArrayList<>();
        List<Shipment> sorted = new ArrayList<>(shipments);
        sorted.sort((first, second) -> {
            int rst = Integer.compare(second.getCost(), first.getCost());
            return rst != 0 ? rst : Integer.compare(first.getWeight(), second.getWeight());
        });
        int totalLoad = 0;
        for (Shipment shipment : sorted) {
            if (totalLoad + shipment.getWeight() <= loadCapacity) {
                result.add(shipment);
                totalLoad += shipment.getWeight();
            }
        }
        return result;
    }
}
