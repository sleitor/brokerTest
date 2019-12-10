package test.broker;

import Instruments.Instrument;
import Instruments.Instrument1;
import Instruments.Instrument4;
import org.junit.Before;
import org.junit.Test;
import utils.DateChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static resources.CONSTANTS.POSITIVE_STRING;

public class MainTest {
    Main main;

    @Before
    public void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        main = new Main();

        Method initializeInstruments = Main.class.getDeclaredMethod("initializeInstruments");
        initializeInstruments.setAccessible(true);
        initializeInstruments.invoke(main);
    }

    @Test
    public void getInstrumentPositiveTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getInstrument = Main.class.getDeclaredMethod("getInstrument", String.class);
        getInstrument.setAccessible(true);
        Instrument instrument = (Instrument) getInstrument.invoke(main, "INSTRUMENT1");

        assertTrue(POSITIVE_STRING, instrument instanceof Instrument1);

    }

    @Test
    public void getInstrumentNegativeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getInstrument = Main.class.getDeclaredMethod("getInstrument", String.class);
        getInstrument.setAccessible(true);
        Instrument instrument = (Instrument) getInstrument.invoke(main, "WrongNameInstrument");

        assertNotNull(instrument);
        assertTrue(POSITIVE_STRING, instrument instanceof Instrument4);


    }

    @Test
    public void processingPositiveTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method getInstrument = Main.class.getDeclaredMethod("getInstrument", String.class);
        getInstrument.setAccessible(true);
        Instrument instrument = (Instrument) getInstrument.invoke(main, "INSTRUMENT1");

        Method processing = Main.class.getDeclaredMethod("processing", String.class);
        processing.setAccessible(true);

        assertEquals(POSITIVE_STRING, instrument.toString(), "INSTRUMENT1 : 0.0 matched count: 0");

        Field DATE_CHECKER = Main.class.getDeclaredField("DATE_CHECKER");
        DATE_CHECKER.setAccessible(true);
        DATE_CHECKER.set(main, new DateChecker("01-Jan-1996"));

        processing.invoke(main, "INSTRUMENT1,01-Jan-1996,2.4655");

        assertEquals(POSITIVE_STRING, instrument.toString(), "INSTRUMENT1 : 2.4655 matched count: 1");
    }

    @Test
    public void processingNegativeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method getInstrument = Main.class.getDeclaredMethod("getInstrument", String.class);
        getInstrument.setAccessible(true);
        Instrument instrument = (Instrument) getInstrument.invoke(main, "INSTRUMENT1");

        Method processing = Main.class.getDeclaredMethod("processing", String.class);
        processing.setAccessible(true);

        assertEquals(POSITIVE_STRING, instrument.toString(), "INSTRUMENT1 : 0.0 matched count: 0");

        Field DATE_CHECKER = Main.class.getDeclaredField("DATE_CHECKER");
        DATE_CHECKER.setAccessible(true);
        DATE_CHECKER.set(main, new DateChecker("01-Jan-1996"));

        processing.invoke(main, "INSTRUMENT1,02-Jan-1996,2.4655");

        assertEquals(POSITIVE_STRING, instrument.toString(), "INSTRUMENT1 : 0.0 matched count: 0");

    }

    @Test
    public void testMain() throws IOException {
        System.out.println("main");
        String[] args = new String[1];
        args[0] = "12-12-2012";
        final InputStream original = System.in;

        File file = new File("testDataForDateChecker.txt");
        if (!file.exists()) assertTrue(file.createNewFile());

        final FileInputStream fips = new FileInputStream(file);
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }
}
