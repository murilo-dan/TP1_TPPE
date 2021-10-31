import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public static void write(String delimiter, String outPath, String format, String path, String fileName) throws ArquivoNaoEncontradoException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.readFile(path + fileName);
        if(fileName.contains("Time"))
            fileName = "analysisTimeTab.out";
        else if (fileName.contains("Memory"))
            fileName = "analysisMemoryTab.out";
        if (format.toLowerCase().equals("coluna")) {
            Persistencia.column(fileReader, delimiter, outPath, fileName);
        } else {
            Persistencia.line(fileReader, delimiter, outPath, fileName);
        }

    }

}
