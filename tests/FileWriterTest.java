import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class FileWriterTest {

    @Test
    public void write() throws ArquivoNaoEncontradoException, IOException {
        FileWriter.write(";", "resource\\output\\", "coluna", "resource\\input\\","analysisTime.out");
        File file = new File("resource\\output\\" + "analysisTimeTab.out");
        assertEquals(true, file.isFile());
    }

    @Test
    public void writeColumn() throws ArquivoNaoEncontradoException, IOException {
        FileWriter.write(";", "resource\\output\\", "coluna", "resource\\input\\","analysisTime.out");
        List<String> column = Files.readAllLines(Paths.get("resource\\output\\" + "analysisTimeTab.out"), StandardCharsets.UTF_8);

        assertTrue(column.get(0).contains("0;1;2;3"));
    }

    @Test
    public void writeLine() throws ArquivoNaoEncontradoException, IOException {
        FileWriter.write(";", "resource\\output\\", "line", "resource\\input\\","analysisTime.out");
        List<String> lines = Files.readAllLines(Paths.get("resource\\output\\" + "analysisTimeTab.out"), StandardCharsets.UTF_8);

        assertTrue(lines.get(0).contains("0;1110;3200;934"));
    }

    @After
    public void after() {
        File file = new File("resource\\output\\analysisTimeTab.out");
        file.delete();
    }

}