package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static resources.CONSTANTS.POSITIVE_STRING;
import static utils.Strings.parseString;

public class StringsTest {
    @Test
    public void parseStringPositiveTest() {
        String[] parsedStrings = parseString("Test string", " ");
        assertEquals(POSITIVE_STRING, parsedStrings[0], "Test");
        assertEquals(POSITIVE_STRING, parsedStrings[1], "string");
    }

    @Test
    public void parseStringNegativeTest() {
        String[] parsedStrings = parseString("Test string", "q");
        assertEquals(POSITIVE_STRING, parsedStrings[0], "Test string");

    }
}
