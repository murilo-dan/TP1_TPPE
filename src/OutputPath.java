import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OutputPath {

    public OutputPath() {
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws EscritaNaoPermitidaException {
        File file = new File(path);

        if (!file.isDirectory())
            throw new EscritaNaoPermitidaException("Diretorio não existe");
        if (!Files.isWritable(Paths.get(path)))
            throw new EscritaNaoPermitidaException("Escrita não permitida");


        this.path = path;
    }
}
