import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileReader extends Persistencia{

    public FileReader() {
    }

    public List<String> readFile(String fileName) throws ArquivoNaoEncontradoException {
        return super.persistenciaRead(fileName);
    }

}
