import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Persistencia {

    private int evolutions;
    private int analysis;
    private List<String> lines;
    private int maxAnalysis;
    private Queue<Integer> queueEvolutions;
    private Queue<Integer> queueAnalysis;
    private Queue<Integer> analysisData;

    public Persistencia() {
    }

    public  List<String> fileRead(String fileName) throws ArquivoNaoEncontradoException {

        lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArquivoNaoEncontradoException(fileName);
        }

        return lines;
    }

    public int getEvolutions() {
        return queueEvolutions.poll();
    }

    public int getAnalysis() {
        return queueAnalysis.poll();
    }

    public Queue<Integer> getAnalysisData() {
        return analysisData;
    }

    public int getEvolutionsNumber() {
        return evolutions;
    }

    public int getMaxAnalysis() {
        return maxAnalysis;
    }

    public static void column(FileReader fileReader, String delimiter, String outPath, String fileName) throws IOException {
        Column.column(fileReader, delimiter, outPath, fileName);
    }

    public static void line(FileReader fileReader, String delimiter, String outPath, String fileName) throws IOException {
        Line line = new Line(fileReader.getEvolutionsNumber());
        Line.line(fileReader, delimiter, outPath, fileName);
    }

    public List<String> evolutionsAndAnalysis(String fileName) throws ArquivoNaoEncontradoException {
        queueEvolutions = new ArrayDeque<>();
        queueAnalysis = new ArrayDeque<>();
        analysisData = new ArrayDeque<>();
        maxAnalysis = Integer.MIN_VALUE;
        List<String> lines = fileRead(fileName);

        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).contains("Evolution")) {
                queueEvolutions.add(evolutions);
                maxAnalysis = Math.max(maxAnalysis, analysis);
                analysis = 0;
                evolutions++;
            } else {
                analysisData.add(Integer.parseInt(lines.get(i)));
                analysis++;
            }
            if(i + 1 < lines.size() && lines.get(i + 1).contains("Evolution")) {
                queueAnalysis.add(analysis);
            }
        }
        queueAnalysis.add(analysis);
        return lines;
    }
}
