package Instruments;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static resources.CONSTANTS.POSITIVE_STRING;

public class ValueByDateTest {
    private static ValueByDate valueByDate;

    @Before
    public void setUp() {
        valueByDate = new ValueByDate(LocalDate.of(2010, 10, 12), 10.2, "");
    }

    @Test
    public void getterAndSetterPositive() {
        assertEquals(POSITIVE_STRING, valueByDate.getValue(), 10.2, 0);
        assertEquals(POSITIVE_STRING, valueByDate.getDate(), LocalDate.of(2010, 10, 12));

        valueByDate.setDate(LocalDate.of(2012, 12, 12));
        assertEquals(POSITIVE_STRING, valueByDate.getDate(), LocalDate.of(2012, 12, 12));

        valueByDate.setValue(14);
        assertEquals(POSITIVE_STRING, valueByDate.getValue(), 14, 0);
    }

    @Test
    public void toStringTest() {
        assertEquals(POSITIVE_STRING, valueByDate.toString(), "{ date: 2010-10-12, value: 10.2 }");
    }
}
