import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String fileName) throws ArquivoNaoEncontradoException {

        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            throw new ArquivoNaoEncontradoException(fileName);
        }
        return lines;

    }

}
