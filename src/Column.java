import java.io.BufferedWriter;
import java.io.IOException;

public class Column {
    private static BufferedWriter writer;
    private static int[][] ints;

    public Column() {
    }

    public static void column(FileReader fileReader, String delimiter, String outPath, String fileName) throws IOException {
        writer = new BufferedWriter(new java.io.FileWriter(outPath + fileName, true));
        ints = new int[fileReader.getEvolutionsNumber()][fileReader.getMaxAnalysis()];
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
                    writer.write(delimiter);
            }
            writer.newLine();
        }
        writer.close();
    }
}

