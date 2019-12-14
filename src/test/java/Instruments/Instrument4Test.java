package Instruments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Instrument4Test {
    private static Instrument4 instrument4;

    @Before
    public void initializeClass() {
        instrument4 = new Instrument4("Test");
    }

    @Test
    public void freshInstance() {
        assertEquals(instrument4.toString(), "Test : 0.0");
    }

//    @Test
//    public void toStringTest() {
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 0.0");
//
//        instrument4.calculate(10, LocalDate.of(2014, 12, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2014-12-01, value: 10.0 }");
//    }
//
//    @Test
//    public void calculatePositive() {
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 0.0");
//
//        instrument4.calculate(10, LocalDate.of(2014, 12, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2014-12-01, value: 10.0 }");
//
//        instrument4.calculate(9, LocalDate.of(2014, 12, 2));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 19.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 }");
//
//        instrument4.calculate(8, LocalDate.of(2014, 12, 3));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 27.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 }");
//
//        instrument4.calculate(7, LocalDate.of(2014, 12, 4));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 34.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 }");
//
//        instrument4.calculate(6, LocalDate.of(2014, 12, 5));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 40.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 }");
//
//        instrument4.calculate(5, LocalDate.of(2014, 12, 8));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 45.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 }");
//
//        instrument4.calculate(4, LocalDate.of(2014, 12, 9));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 49.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 }");
//
//        instrument4.calculate(3, LocalDate.of(2014, 12, 10));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 52.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 } { date: 2014-12-10, value: 3.0 }");
//
//        instrument4.calculate(2, LocalDate.of(2014, 12, 11));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 54.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 } { date: 2014-12-10, value: 3.0 } { date: 2014-12-11, value: 2.0 }");
//
//        instrument4.calculate(1, LocalDate.of(2014, 12, 12));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 55.0 { date: 2014-12-01, value: 10.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 } { date: 2014-12-10, value: 3.0 } { date: 2014-12-11, value: 2.0 } { date: 2014-12-12, value: 1.0 }");
//
//        instrument4.calculate(0, LocalDate.of(2014, 12, 15));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 45.0 { date: 2014-12-15, value: 0.0 } { date: 2014-12-02, value: 9.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 } { date: 2014-12-10, value: 3.0 } { date: 2014-12-11, value: 2.0 } { date: 2014-12-12, value: 1.0 }");
//
//        instrument4.calculate(50, LocalDate.of(2014, 12, 16));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 86.0 { date: 2014-12-15, value: 0.0 } { date: 2014-12-16, value: 50.0 } { date: 2014-12-03, value: 8.0 } { date: 2014-12-04, value: 7.0 } { date: 2014-12-05, value: 6.0 } { date: 2014-12-08, value: 5.0 } { date: 2014-12-09, value: 4.0 } { date: 2014-12-10, value: 3.0 } { date: 2014-12-11, value: 2.0 } { date: 2014-12-12, value: 1.0 }");
//    }
//
//    @Test
//    public void calculateNegative() {
//        // initialize class with one value
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 0.0");
//        instrument4.calculate(10, LocalDate.of(2020, 1, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//
//        // try to add NaN
//        instrument4.calculate(Double.NaN, LocalDate.of(2020, 1, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//
//        // try to add NEGATIVE_INFINITY
//        instrument4.calculate(Double.NEGATIVE_INFINITY, LocalDate.of(2020, 1, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//
//        // try to add POSITIVE_INFINITY
//        instrument4.calculate(Double.POSITIVE_INFINITY, LocalDate.of(2020, 1, 1));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//
//        // try to add negative value
//        instrument4.calculate(-1, LocalDate.of(2014, 12, 16));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//
//        // try to add weekends
//        instrument4.calculate(10, LocalDate.of(2014, 12, 14));
//        assertEquals(POSITIVE_STRING, instrument4.toString(), "Test : 10.0 { date: 2020-01-01, value: 10.0 }");
//    }
}
