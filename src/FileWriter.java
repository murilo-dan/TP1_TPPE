import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public static void write(char delimiter, String outPath, String format, String path, String fileName) throws ArquivoNaoEncontradoException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.readFile(path + fileName);
        if (format.toLowerCase().equals("coluna")) {
            column(fileReader, delimiter, outPath, fileName);
        } else {
            line(fileReader, delimiter, outPath, fileName);
        }


    }

    public static void column(FileReader fileReader, char delimiter, String outPath, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outPath + fileName, true));
        int[][] ints = new int[fileReader.getEvolutionsNumber()][fileReader.getMaxAnalysis()];
        writer.write( "0");
        for (int i = 1; i < fileReader.getEvolutionsNumber(); i++) {
            writer.write(delimiter + "" + i );
        }
        writer.newLine();
        for (int i = 0; i < fileReader.getEvolutionsNumber(); i++) {
            int analysis = fileReader.getAnalysis();
            for (int j = 0; j < analysis; j++) {
                ints[i][j] = fileReader.getAnalysisData().poll();
            }
        }
        for (int j = 0; j < fileReader.getMaxAnalysis(); j++) {
            writer.write(ints[0][j] + "");
            for (int i = 0; i < fileReader.getEvolutionsNumber(); i++) {
                if(ints[i][j] != 0)
                    writer.write(delimiter + "" + ints[i][j]);
                else
                    writer.write(";");
            }
            writer.newLine();
        }
        writer.close();


    }

    public static void line(FileReader fileReader, char delimiter, String outPath, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outPath + fileName, true));
        int evolutions = fileReader.getEvolutionsNumber();
        for (int i = 0; i < evolutions; i++) {
            writer.write(i + "");
            int analysis = fileReader.getAnalysis();
            for (int j = 0; j < analysis; j++) {
                writer.write(delimiter + "" + fileReader.getAnalysisData().poll());
            }
            writer.newLine();
        }
        writer.close();
    }

}
