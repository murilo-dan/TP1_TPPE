import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private String path;

    @Test
    public void readFile() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";

        assertEquals(true, FileReader.readFile(path) instanceof List);
    }

    @Test (expected = ArquivoNaoEncontradoException.class)
    public void readFileWithError() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\downloadss\\analysisTime.out";
        FileReader.readFile(path);
    }

    @Test
    public void readFile3() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";
        String first = "---------- Evolution 0 ----------";

        assertEquals(first, FileReader.readFile(path).get(0));
    }
}