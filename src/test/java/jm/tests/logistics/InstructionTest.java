package jm.tests.logistics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class InstructionTest {

    @Test
    public void testToString() {
        Instruction instruction = new Instruction(List.of(
                new Shipment("table", 10, 2000),
                new Shipment("bed", 20, 4000)
        ));
        assertThat(instruction.getTotalCost(), is(6000));
        assertThat(instruction.toString(), is("table bed 6000"));
    }
}
