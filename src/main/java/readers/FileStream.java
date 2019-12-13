package readers;

import lombok.Getter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream implements AbstractStream {
    @Getter
    private Stream<String> resource;

    public FileStream(String path) throws IOException {
        resource = Files
                .lines(Paths.get(path == null ? "Financial_instruments_input Инструменты.txt" : path), StandardCharsets.UTF_8)
                .parallel();
    }
}
