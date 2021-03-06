package Instruments;

import org.junit.Test;

import java.time.LocalDate;

import static Instruments.Instrument.isAllowedDate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static resources.CONSTANTS.IS_NON_WEEKEND;
import static resources.CONSTANTS.IS_WEEKEND;

public class InstrumentTest {

    @Test
    public void isAllowedDatePositiveTest() {
        assertTrue("2019-12-13 - " + IS_NON_WEEKEND, isAllowedDate(LocalDate.of(2019, 12, 13)));
    }

    @Test
    public void isAllowedDateNegativeTest() {
        assertFalse("2019-12-14 - " + IS_WEEKEND, isAllowedDate(LocalDate.of(2019, 12, 14)));
        assertFalse("2019-12-15 - " + IS_WEEKEND, isAllowedDate(LocalDate.of(2019, 12, 15)));
    }
}
