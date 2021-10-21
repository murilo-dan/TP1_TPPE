import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    private Menu menu;

    @Before
    public void setup() {
        menu = new Menu();
    }

    @Test
    public void setDelimiter() throws DelimitadorInvalidoException {
        menu.setDelimiter("b");
        assertEquals("b", menu.getDelimiter());
    }

    @Test
    public void setDelimiter2() throws DelimitadorInvalidoException {
        menu.setDelimiter("d");
        assertEquals("d", menu.getDelimiter());
    }

    @Test (expected = DelimitadorInvalidoException.class)
    public void setDelimiterError() throws DelimitadorInvalidoException {
        menu.setDelimiter("string");
    }
}