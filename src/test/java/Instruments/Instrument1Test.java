package Instruments;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static resources.CONSTANTS.NEGATIVE_STRING;
import static resources.CONSTANTS.POSITIVE_STRING;

public class Instrument1Test {
    private static Instrument1 instrument1;

    @Before
    public void initializeClass() {
        instrument1 = new Instrument1("Test");
    }

    @Test
    public void getNamePositive() {
        assertEquals(instrument1.getNAME(), "Test");
    }

    @Test
    public void getNameNegative() {
        assertNotEquals(instrument1.getNAME(), "TestWrong");
    }

    @Test
    public void setAndGetResultPositive() {
        double testedValue = 5d;

        double res = instrument1.getResult();
        assertNotEquals(NEGATIVE_STRING, res, instrument1.getCount());
        instrument1.setResult(testedValue);
        assertEquals(POSITIVE_STRING, res, instrument1.getCount(), 0d);
    }

    @Test
    public void setAndGetResultNegative() {
        double testedValue = 5d;

        double res = instrument1.getResult();
        instrument1.setResult(testedValue);
        assertNotEquals(NEGATIVE_STRING, res + 1d, instrument1.getCount(), 0d);
    }

    @Test
    public void toStringPositive() {
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 0.0 matched count: 0");
    }


    @Test
    public void toStringNegative() {
        assertNotEquals(NEGATIVE_STRING, instrument1.toString(), "TestWrong : 0.0 matched count: 0");
    }

    @Test
    public void calculatePositive() {
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 0.0 matched count: 0");

        instrument1.calculate(10, LocalDate.of(2020, 1, 1));
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 10.0 matched count: 1");

        instrument1.calculate(4, LocalDate.of(2020, 1, 2));
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 7.0 matched count: 2");

    }

    @Test
    public void calculateNegative() {
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 0.0 matched count: 0");

        instrument1.calculate(10, LocalDate.of(2020, 1, 4));
        assertEquals(POSITIVE_STRING, instrument1.toString(), "Test : 0.0 matched count: 0");
    }
}
