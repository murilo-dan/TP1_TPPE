import java.io.IOException;

public class ArquivoNaoEncontradoException extends Exception {
    public ArquivoNaoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}
