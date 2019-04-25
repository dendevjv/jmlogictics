package jm.tests.logistics;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ShipmentTest {

    @Test
    public void whenCorrectInputThenInstantiateShipment() {
        String input = "table/30/7000";
        Shipment result = Shipment.parse(input);
        Shipment expected = new Shipment("table", 30, 7000);
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncompleteInputThenThrowException() {
        String input = "table/7000";
        Shipment.parse(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectInputThenThrowException() {
        String input = "table/abc/7000";
        Shipment.parse(input);
    }
}
