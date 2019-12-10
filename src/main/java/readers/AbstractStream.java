package readers;

import java.util.stream.Stream;

public interface AbstractStream {
    Stream<String> getResource();

}
