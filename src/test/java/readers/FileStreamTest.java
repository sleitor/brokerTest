package readers;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertNotNull;
import static resources.CONSTANTS.POSITIVE_STRING;

public class FileStreamTest {


    @Test
    public void createFileStreamPositiveTest() throws IOException {
        new FileStream(null);
    }

    @Test(expected = NoSuchFileException.class)
    public void createFileStreamNegativeTest() throws IOException {
        new FileStream("null");
    }

    @Test
    public void getterTest() throws IOException {
        FileStream fileStream = new FileStream(null);
        assertNotNull(POSITIVE_STRING, fileStream.getResource());

    }
}
