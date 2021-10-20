import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutputPathTest {

    private OutputPath path;

    @Before
    public void setup() {
        path = new OutputPath();
    }

    @Test
    public void getPaths() {
        path.setPath("C:\\User\\Student");
        String expected = "C:\\User\\Student";

        assertEquals(expected, path.getPath());
    }
}