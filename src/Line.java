import java.io.BufferedWriter;
import java.io.IOException;

public class Line {
    private static BufferedWriter writer;
    private static int evolutions;

    public Line(int evolutions) {
        this.evolutions = evolutions;
    }

    public static void line(FileReader fileReader, String delimiter, String outPath, String fileName) throws IOException {
        writer = new BufferedWriter(new java.io.FileWriter(outPath + fileName, true));
        evolutions = fileReader.getEvolutionsNumber();
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
