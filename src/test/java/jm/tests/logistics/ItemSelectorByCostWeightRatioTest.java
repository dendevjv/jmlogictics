package jm.tests.logistics;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ItemSelectorByCostWeightRatioTest {

    @Test
    public void whenSelectThenReturnsItemsGivingMaximumCost() {
        var shipments = List.of(
                new Item("a", 30, 7000),
                new Item("b", 40, 9000),
                new Item("c", 10, 6000),
                new Item("d", 40, 10000)
        );
        var result = new ItemSelectorByCostWeightRatio().select(50, shipments);
        assertThat(result.size(), is(2));
        assertThat(result, hasItem(new Item("c", 10, 6000)));
        assertThat(result, hasItem(new Item("d", 40, 10000)));
    }

    @Test
    public void whenSelectFromLightExpensiveItemsThenReturnsItemsGivingMaximumCost() {
        var shipments = List.of(
                new Item("a", 30, 7000),
                new Item("b", 40, 9000),
                new Item("c", 10, 6000),
                new Item("d", 40, 10000),
                new Item("e", 3, 5000),
                new Item("f", 3, 5000),
                new Item("g", 1, 3000)
        );
        var result = new HashSet<>(new ItemSelectorByCostWeightRatio().select(50, shipments));
        Set<Item> expected = Set.of(
                new Item("a", 30, 7000),
                new Item("c", 10, 6000),
                new Item("e", 3, 5000),
                new Item("f", 3, 5000),
                new Item("g", 1, 3000)
        );
        assertThat(result, is(expected));
    }

    @Ignore
    @Test
    public void whenSelectThenReturnsItemsGivingMaximumCost2() {
        var shipments = List.of(
                new Item("a", 51, 99),
                new Item("b", 50, 50),
                new Item("c", 50, 50)
        );
        var result = new ItemSelectorByCostWeightRatio().select(100, shipments);
        assertThat(result.size(), is(2));
        assertThat(result, hasItem(new Item("b", 50, 50)));
        assertThat(result, hasItem(new Item("c", 50, 50)));
    }
}
