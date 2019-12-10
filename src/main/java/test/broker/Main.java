package test.broker;

import Instruments.*;
import consumers.AbstractConsumer;
import consumers.ConsoleOut;
import readers.FileStream;
import utils.DateChecker;
import utils.Strings;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    private static final HashMap<String, Instrument> instrumentHashMap = new HashMap<>();
    private static DateChecker DATE_CHECKER;

    public static void main(String[] args) throws IOException {

        initializeInstruments();
        DATE_CHECKER = new DateChecker(args.length > 0 ? args[0] : null);
        AbstractConsumer consumer = new ConsoleOut();
        long StartTime = System.currentTimeMillis();

//=====================================================================================================================
        String path = args.length == 2 ? args[1] : null;

        new FileStream(path).getResource().forEach(Main::processing);

        LinkedList<String> messages = new LinkedList<>();

        for (Instrument instrument : instrumentHashMap.values()) {
            messages.add(instrument.toString());
        }
//=====================================================================================================================
        messages.add("Время обработки файла: " + (System.currentTimeMillis() - StartTime));

        consumer.send(messages.iterator());
    }

    private static void initializeInstruments() {
        instrumentHashMap.put("INSTRUMENT1", new Instrument1("INSTRUMENT1"));
        instrumentHashMap.put("INSTRUMENT2", new Instrument2("INSTRUMENT2", 2014, 11));
        instrumentHashMap.put("INSTRUMENT3", new Instrument3("INSTRUMENT3"));
        instrumentHashMap.put("DEFAULT", new Instrument4("INSTRUMENT4"));
    }

    private static void processing(String str) {
        String[] strings = Strings.parseString(str, ",");
        LocalDate date = DATE_CHECKER.dateParser(strings[1]);
        if (DATE_CHECKER.isFuture(date)) return;

        getInstrument(strings[0])
                .calculate(Double.parseDouble(strings[2]), date);
    }

    private static Instrument getInstrument(String name) {
        Instrument instrument = instrumentHashMap.get(name);
        if (instrument == null) return instrumentHashMap.get("DEFAULT");

        return instrument;
    }
}
