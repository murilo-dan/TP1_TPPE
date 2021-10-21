import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileWriterTest {

    @Test
    public void write() throws ArquivoNaoEncontradoException, IOException {
        FileWriter.write(';', "C:\\Users\\analu\\", "coluna", "C:\\Users\\analu\\Downloads\\","analysisTime.out");
        File file = new File("C:\\Users\\analu\\" + "analysisTime.out");

        assertEquals(true, file.isFile());
    }
}