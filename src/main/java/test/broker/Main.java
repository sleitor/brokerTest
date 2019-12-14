package test.broker;

import Instruments.InstrumentRunner;
import consumers.ConsoleOut;
import readers.FileStream;

import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        RowAnalyzer rowAnalyzer = args.length > 0 ? new RowAnalyzer(args[0]) : new RowAnalyzer();
        InstrumentRunner instrumentRunner = new InstrumentRunner();
        long StartTime = System.currentTimeMillis();

//=====================================================================================================================
        String path = args.length == 2 ? args[1] : null;

        for (int i = 0; i < 1_000; i++) {
            try (Stream<String> strings = new FileStream(path).getResource()) {
                strings.forEach((s -> instrumentRunner.run(rowAnalyzer.parse(s))));
            }
        }

        LinkedList<String> messages = instrumentRunner.summary();

//=====================================================================================================================
        messages.add("Время обработки файла: " + (System.currentTimeMillis() - StartTime));

        new ConsoleOut().send(messages.iterator());
    }
}
