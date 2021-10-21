import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileReader {

    private int evolutions;
    private int analysis;
    List<String> lines;
    private Queue<Integer> queueEvolutions;
    private Queue<Integer> queueAnalysis;

    public FileReader() {
    }

    public List<String> readFile(String fileName) throws ArquivoNaoEncontradoException {
        queueEvolutions = new ArrayDeque<>();
        queueAnalysis = new ArrayDeque<>();
        lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ArquivoNaoEncontradoException(fileName);
        }

        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).contains("Evolution")) {
                queueEvolutions.add(evolutions);
                analysis = 0;
                evolutions++;
            } else {
                analysis++;
            }
            if(i + 1 < lines.size() && lines.get(i + 1).contains("Evolution")) {
                queueAnalysis.add(analysis);
            }
        }
        queueAnalysis.add(analysis);
//        for (int i = 0; i < evolutions; i++) {
//            System.out.print(queue.poll() + " ");
//            System.out.println(queue2.poll());
//        }
        return lines;

    }

    public int getEvolutions() {
        return queueEvolutions.poll();
    }

    public int getAnalysis() {
        return queueAnalysis.poll();
    }

}
