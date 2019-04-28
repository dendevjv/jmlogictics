package jm.tests.logistics;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TruckTest {

    @Test
    public void testAdd() {
        Truck truck = new Truck(10);
        assertThat(truck.add(new Item("a", 7, 10)), is(true));
        assertThat(truck.add(new Item("b", 6, 10)), is(false));
        assertThat(truck.getFreeCapacity(), is(3));
        assertThat(truck.getLoadCapacity(), is(10));
        assertThat(truck.getItems().size(), is(1));
        assertThat(truck.getItems().get(0), is(new Item("a", 7, 10)));
    }

    @Test
    public void testItemsDescription() {
        Truck truck = new Truck(15);
        truck.add(new Item("a", 7, 10));
        truck.add(new Item("b", 8, 20));
        assertThat(truck.itemsDescription(), is("a b 30"));
    }
}
