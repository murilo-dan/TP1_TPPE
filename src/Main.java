import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DelimitadorInvalidoException, ArquivoNaoEncontradoException, IOException {
        Scanner sc = new Scanner(System.in);
        String path;
        String fileName;
        String delimiter;
        String format;
        String outputPath;

        System.out.println("Digite o caminho do arquivo de entrada:");
        path = sc.next();

        System.out.println("Digite o nome do arquivo:");
        fileName = sc.next();

        System.out.println("Digite o delimitador:");
        delimiter = sc.next();

        System.out.println("O formato sera em linha ou coluna?");
        format = sc.next();

        System.out.println("Digite o caminho de saída:");
        outputPath = sc.next();

        Menu menu = new Menu();
        menu.setDelimiter(delimiter);

        FileWriter.write(delimiter, outputPath, format, path, fileName);

    }
}
