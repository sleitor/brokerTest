package consumers;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ConsoleOutTest {
    static AbstractConsumer console;

    @Before
    public void setUp() {
        console = new ConsoleOut();
    }

    @Test
    public void ConsoleTest() {
        LinkedList<String> message = new LinkedList<>();
        message.add("Console Test");
        console.send(message.iterator());
    }
}
