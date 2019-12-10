package Instruments;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static resources.CONSTANTS.NEGATIVE_STRING;
import static resources.CONSTANTS.POSITIVE_STRING;

public class Instrument3Test {
    private static Instrument3 instrument3;

    @Before
    public void initializeClass() {
        instrument3 = new Instrument3("Test");
    }

    @Test
    public void freshInstance() {
        assertEquals(instrument3.toString(), "Test : NaN");
    }

    @Test
    public void calculatePositive() {
        assertEquals(POSITIVE_STRING, instrument3.toString(), "Test : NaN");

        instrument3.calculate(10, LocalDate.of(2014, 12, 1));
        assertEquals(POSITIVE_STRING, instrument3.toString(), "Test : 10.0");
    }

    @Test
    public void calculateNegative() {
        assertNotEquals(NEGATIVE_STRING, instrument3.toString(), "Test : 0.0");

        instrument3.calculate(10, LocalDate.of(2020, 1, 1));
        instrument3.calculate(Double.NaN, LocalDate.of(2020, 1, 1));
        assertEquals(POSITIVE_STRING, instrument3.toString(), "Test : 10.0");

        instrument3.calculate(Double.NEGATIVE_INFINITY, LocalDate.of(2020, 1, 1));
        assertEquals(POSITIVE_STRING, instrument3.toString(), "Test : 10.0");

        instrument3.calculate(Double.POSITIVE_INFINITY, LocalDate.of(2020, 1, 1));
        assertEquals(POSITIVE_STRING, instrument3.toString(), "Test : 10.0");
    }
}
