import org.junit.Test;

import static org.junit.Assert.*;

public class OutputFormatTest {

    @Test
    public void getFormat() {
        assertEquals(true, OutputFormat.LINHA.getFormat());
    }
}