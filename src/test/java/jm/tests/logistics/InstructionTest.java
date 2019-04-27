package jm.tests.logistics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class InstructionTest {

    @Test
    public void testToString() {
        Instruction instruction = new Instruction(List.of(
                new Item("table", 10, 2000),
                new Item("bed", 20, 4000)
        ));
        assertThat(instruction.toString(), is("table bed 6000"));
    }
}
