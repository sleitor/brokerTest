package consumers;

import java.util.Iterator;

public interface AbstractConsumer {
    void send(Iterator<String> message);
}
