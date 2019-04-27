package jm.tests.logistics;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ShipmentSelectorNaiveImplTest {

    @Test
    public void whenSelectThenReturnsItemsGivingMaximumCost() {
        var shipments = List.of(
                new Shipment("a", 30, 7000),
                new Shipment("b", 40, 9000),
                new Shipment("c", 10, 6000),
                new Shipment("d", 40, 10000)
        );
        var result = new ShipmentSelectorNaiveImpl().select(50, shipments);
        assertThat(result.size(), is(2));
        assertThat(result, hasItem(new Shipment("c", 10, 6000)));
        assertThat(result, hasItem(new Shipment("d", 40, 10000)));
    }

    @Test
    public void whenSelectFromLightExpensiveItemsThenReturnsItemsGivingMaximumCost() {
        var shipments = List.of(
                new Shipment("a", 30, 7000),
                new Shipment("b", 40, 9000),
                new Shipment("c", 10, 6000),
                new Shipment("d", 40, 10000),
                new Shipment("e", 3, 5000),
                new Shipment("f", 3, 5000),
                new Shipment("g", 1, 3000)
        );
        var result = new HashSet<>(new ShipmentSelectorNaiveImpl().select(50, shipments));
        Set<Shipment> expected = Set.of(
                new Shipment("a", 30, 7000),
                new Shipment("c", 10, 6000),
                new Shipment("e", 3, 5000),
                new Shipment("f", 3, 5000),
                new Shipment("g", 1, 3000)
        );
        assertThat(result, is(expected));
    }

    @Ignore
    @Test
    public void whenSelectThenReturnsItemsGivingMaximumCost2() {
        var shipments = List.of(
                new Shipment("a", 51, 99),
                new Shipment("b", 50, 50),
                new Shipment("c", 50, 50)
        );
        var result = new ShipmentSelectorNaiveImpl().select(100, shipments);
        assertThat(result.size(), is(2));
        assertThat(result, hasItem(new Shipment("b", 50, 50)));
        assertThat(result, hasItem(new Shipment("c", 50, 50)));
    }
}
