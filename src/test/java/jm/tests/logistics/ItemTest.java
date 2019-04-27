package jm.tests.logistics;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenCorrectInputThenInstantiateShipment() {
        String input = "table/30/7000";
        Item result = Item.parse(input);
        Item expected = new Item("table", 30, 7000);
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncompleteInputThenThrowException() {
        String input = "table/7000";
        Item.parse(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectInputThenThrowException() {
        String input = "table/abc/7000";
        Item.parse(input);
    }
}
