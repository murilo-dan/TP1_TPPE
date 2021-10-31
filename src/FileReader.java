import java.util.*;

public class FileReader extends Persistencia{

    public FileReader() {
    }

    public List<String> readFile(String fileName) throws ArquivoNaoEncontradoException {
        return super.evolutionsAndAnalysis(fileName);
    }

}
