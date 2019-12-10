package utils;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.Assert.*;
import static resources.CONSTANTS.POSITIVE_STRING;

public class DateCheckerTest {
    private DateChecker dateChecker;

    @Before
    public void setUp() {
        dateChecker = new DateChecker(null, DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH));
    }

    @Test
    public void getDateFormatter() {
        assertEquals(
                POSITIVE_STRING, dateChecker.getDF().toString(),
                DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH).toString()
        );
    }

    @Test
    public void constructorPositiveTest() {
        DateChecker dateChecker = new DateChecker("12-Mar-2010");

        assertEquals(POSITIVE_STRING, dateChecker.getCurrentDate(), LocalDate.of(2010, 3, 12));
    }

    @Test
    public void isFuturePositiveTest() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        assertTrue(POSITIVE_STRING, dateChecker.isFuture(localDate));
    }

    @Test
    public void isFutureNegativeTest() {
        assertFalse(POSITIVE_STRING, dateChecker.isFuture(LocalDate.now()));

        LocalDate localDate = LocalDate.now().minusDays(1);
        assertFalse(POSITIVE_STRING, dateChecker.isFuture(localDate));
    }

    @Test
    public void setAndGetCurrentDatePositiveTest() {
        assertEquals(POSITIVE_STRING, dateChecker.getCurrentDate(), LocalDate.now());

        dateChecker.setDate("12-Mar-2015");
        assertEquals(POSITIVE_STRING, dateChecker.getCurrentDate(), LocalDate.of(2015, 3, 12));
    }

    @Test
    public void dateParserPositiveTest() {
        assertEquals(POSITIVE_STRING, dateChecker.dateParser("23-Jun-2015"), LocalDate.of(2015, 6, 23));
    }

    @Test
    public void dateParserNegativeTest() {
        assertNull(POSITIVE_STRING, dateChecker.dateParser("32-Jun-2015"));

    }

    @Test(timeout = 200)
    public void constructorNegativeTest() throws IOException {
        final InputStream original = System.in;

        File file = new File("testDataForDateChecker.txt");
        if (!file.exists()) assertTrue(file.createNewFile());

        final FileInputStream fips = new FileInputStream(file);
        System.setIn(fips);
        DateChecker dateChecker = new DateChecker("12-10-2010");

        assertEquals(POSITIVE_STRING, dateChecker.getCurrentDate(), LocalDate.of(2030, 12, 12));

        System.setIn(original);
    }
}
