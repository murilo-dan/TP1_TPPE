import org.junit.Test;

import static org.junit.Assert.*;

public class OutputFormatTest {

    @Test
    public void getFormatLinha() {
        assertEquals(true, OutputFormat.LINHA.getFormat());
    }

    @Test
    public void getFormatColuna() {
        assertEquals(false, OutputFormat.COLUNA.getFormat());
    }

    @Test
    public void getFormatNotEquals() {
        assertNotEquals(true, OutputFormat.COLUNA.getFormat());
    }
}