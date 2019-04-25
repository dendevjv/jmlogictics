package jm.tests.logistics;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain() {
        PrintStream saved = System.out;
        String input = "50" + System.lineSeparator()
                + "table/30/7000 box/40/9000 cleaner/10/6000 bed/40/10000" + System.lineSeparator();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(buffer));
        Main.main(null);
        System.setOut(saved);
        String expectedPrompt = "Грузоподъемность машины в килограммах: "
            + "Введите через пробел предметы в формате название/вес/цена: ";
        String expectedResult = "cleaner bed 16000" + System.lineSeparator();
        String expected = expectedPrompt + expectedResult;
        assertThat(buffer.toString(), is(expected));
    }
}
