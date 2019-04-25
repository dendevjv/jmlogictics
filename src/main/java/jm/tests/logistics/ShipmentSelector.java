package jm.tests.logistics;

import java.util.*;

/**
 * Выбирает предметы для погрузки в порядке уменьшения их стоимости.
 */
public class ShipmentSelector {
    /**
     * Производит отбор предметов для погрузки из предоставленного списка.
     * Отбор производится в порядке уменьшения соотношения стоимости и веса предметов.
     * @param loadCapacity максимальная грузоподъемность машины
     * @param shipments список предметов
     * @return список предметов отобранных для погрузки.
     */
    public List<Shipment> select(int loadCapacity, List<Shipment> shipments) {
        List<Shipment> result = new ArrayList<>();
        List<Shipment> sorted = new ArrayList<>(shipments);
        sorted.sort((first, second) -> Double.compare(
                second.costToWeightRatio(),
                first.costToWeightRatio())
        );
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
