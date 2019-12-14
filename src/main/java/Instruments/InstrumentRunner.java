package Instruments;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class InstrumentRunner {
    private ConcurrentHashMap<String, Instrument> instrumentHashMap = new ConcurrentHashMap<>();

    public InstrumentRunner() {
        instrumentHashMap.put("INSTRUMENT1", new Instrument1("INSTRUMENT1"));
        instrumentHashMap.put("INSTRUMENT2", new Instrument2("INSTRUMENT2", 2014, 11));
        instrumentHashMap.put("INSTRUMENT3", new Instrument3("INSTRUMENT3"));
        instrumentHashMap.put("DEFAULT", new Instrument4("INSTRUMENT4"));
    }

    private Instrument getInstrument(String name) {
        Instrument instrument = instrumentHashMap.get(name);
        if (instrument == null) return instrumentHashMap.get("DEFAULT");

        return instrument;
    }

    public void run(ValueByDate valueByDate) {
        getInstrument(valueByDate.getName()).calculate(valueByDate);
    }

    public LinkedList<String> summary() {
        LinkedList<String> messages = new LinkedList<>();

        for (Instrument instrument : instrumentHashMap.values()) {
            messages.add(instrument.toString());
        }
        return messages;
    }
}
