import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private String path;
    private FileReader fileReader;

    @Before
    public void setup() {
        fileReader = new FileReader();
    }

    @Test
    public void readFile() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";

        assertEquals(true, fileReader.readFile(path) instanceof List);
    }

    @Test (expected = ArquivoNaoEncontradoException.class)
    public void readFileWithError() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\downloadss\\analysisTime.out";
        fileReader.readFile(path);
    }

    @Test
    public void readFile3() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";
        String first = "---------- Evolution 0 ----------";

        assertEquals(first, fileReader.readFile(path).get(0));
    }


    @Test
    public void getEvolutions() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";
        fileReader.readFile(path);
        assertEquals(0, fileReader.getEvolutions());
    }

    @Test
    public void getAnalysis() throws ArquivoNaoEncontradoException {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";
        fileReader.readFile(path);
        assertEquals(0, fileReader.getAnalysis());
    }
}