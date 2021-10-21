import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileReader {

    private int evolutions;
    private int analysis;
    List<String> lines;
    private int maxAnalysis;
    private Queue<Integer> queueEvolutions;
    private Queue<Integer> queueAnalysis;
    private Queue<Integer> analysisData;


    public FileReader() {
    }

    public List<String> readFile(String fileName) throws ArquivoNaoEncontradoException {
        queueEvolutions = new ArrayDeque<>();
        queueAnalysis = new ArrayDeque<>();
        analysisData = new ArrayDeque<>();
        lines = Collections.emptyList();
        maxAnalysis = Integer.MIN_VALUE;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArquivoNaoEncontradoException(fileName);
        }

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
}
