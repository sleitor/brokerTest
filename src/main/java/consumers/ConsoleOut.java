package consumers;

import java.util.Iterator;

public class ConsoleOut implements AbstractConsumer {

    @Override
    public void send(Iterator<String> messages) {
        messages.forEachRemaining((System.out::println));
    }
}
