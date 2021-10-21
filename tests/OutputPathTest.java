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
    public void setPath() throws EscritaNaoPermitidaException {
        path.setPath("C:\\Users\\analu");
        String expected = "C:\\Users\\analu";

        assertEquals(expected, path.getPath());
    }

    @Test (expected = EscritaNaoPermitidaException.class)
    public void setPathErroDirectory() throws EscritaNaoPermitidaException {
        path.setPath("C:\\User\\Student");

    }

    @Test (expected = EscritaNaoPermitidaException.class)
    public void setPathErroWritable() throws EscritaNaoPermitidaException {
        path.setPath("C:\\Windows");
    }
}