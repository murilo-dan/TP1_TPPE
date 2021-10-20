import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class OutputPathTest {

    private OutputPath path;

    @Before
    public void setup() {
        path = new OutputPath();
    }

    @Test
    public void getPath() throws EscritaNaoPermitidaException {
        path.setPath("C:\\Users");
        String expected = "C:\\Users";

        assertEquals(expected, path.getPath());
    }

    @Test (expected = EscritaNaoPermitidaException.class)
    public void getPathErro() throws EscritaNaoPermitidaException {
        path.setPath("C:\\User\\Student");

    }
}