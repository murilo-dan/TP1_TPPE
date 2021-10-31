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
        path = "resource\\input\\analysisTime.out";

        assertEquals(true, fileReader.readFile(path) instanceof List);
    }

    @Test (expected = ArquivoNaoEncontradoException.class)
    public void readFileWithError() throws ArquivoNaoEncontradoException {
        path = "resource\\inputs\\analysisTime.out";
        System.out.println();
        fileReader.readFile(path);
    }

    @Test
    public void readFile3() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        String first = "---------- Evolution 0 ----------";

        assertEquals(first, fileReader.readFile(path).get(0));
    }


    @Test
    public void getEvolutions() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        fileReader.readFile(path);
        assertEquals(0, fileReader.getEvolutions());
    }

    @Test
    public void getEvolutions2() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        fileReader.readFile(path);
        assertEquals(0, fileReader.getEvolutions());
    }

    @Test
    public void getAnalysis2() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        fileReader.readFile(path);
        assertEquals(11, fileReader.getAnalysis());
    }

    @Test
    public void getEvolutions3() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        fileReader.readFile(path);
        fileReader.getEvolutions();
        fileReader.getEvolutions();
        fileReader.getEvolutions();
        assertEquals(3, fileReader.getEvolutions());
    }

    @Test
    public void getAnalysis3() throws ArquivoNaoEncontradoException {
        path = "resource\\input\\analysisTime.out";
        fileReader.readFile(path);
        fileReader.getAnalysis();
        fileReader.getAnalysis();
        fileReader.getAnalysis();
        assertEquals(11, fileReader.getAnalysis());
    }
}