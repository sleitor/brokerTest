package Instruments;

import org.junit.Before;

public class Instrument2Test {
    private static Instrument2 instrument2;

    @Before
    public void initializeClass() {
        instrument2 = new Instrument2("Test", 2014, 12);
    }

//    @Test
//    public void calculatePositive() {
//        assertEquals(POSITIVE_STRING, instrument2.toString(), "Test : 0.0 matched count: 0");
//
//        instrument2.calculate(10, LocalDate.of(2014, 12, 1));
//        assertEquals(POSITIVE_STRING, instrument2.toString(), "Test : 10.0 matched count: 1");
//    }
//
//    @Test
//    public void calculateNegative() {
//        assertNotEquals(NEGATIVE_STRING, instrument2.toString(), "Test : 10.0 matched count: 1");
//
//        instrument2.calculate(10, LocalDate.of(2020, 1, 1));
//        assertEquals(NEGATIVE_STRING, instrument2.toString(), "Test : 0.0 matched count: 0");
//    }
}
