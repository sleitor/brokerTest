package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static resources.CONSTANTS.SHOULD_NUMBER;
import static resources.CONSTANTS.SHOULD_POSITIVE_VALUE;
import static utils.DoubleChecker.invalidNumber;

public class DoubleCheckerTest {

    @Test
    public void invalidNumberPositiveTest() {
        assertFalse(SHOULD_POSITIVE_VALUE, invalidNumber(124.3452));
    }

    @Test
    public void invalidNumberNegativeTest() {
        assertTrue(SHOULD_NUMBER, invalidNumber(Double.NaN));
        assertTrue(SHOULD_NUMBER, invalidNumber(Double.POSITIVE_INFINITY));
        assertTrue(SHOULD_NUMBER, invalidNumber(Double.NEGATIVE_INFINITY));
    }
}
