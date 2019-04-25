package jm.tests.logistics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ShipmentSelectorTest {

    @Test
    public void whenSelectThenReturnsItemsGivingMaximumCost() {
        var shipments = List.of(
                new Shipment("a", 30, 7000),
                new Shipment("b", 40, 9000),
                new Shipment("c", 10, 6000),
                new Shipment("d", 40, 10000)
        );
        var result = new ShipmentSelector().select(50, shipments);
        assertThat(result.size(), is(2));
        assertThat(result, hasItem(new Shipment("c", 10, 6000)));
        assertThat(result, hasItem(new Shipment("d", 40, 10000)));
    }
}
