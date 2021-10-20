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
    public void setDelimiter() {
        menu.setDelimiter('b');
        assertEquals('b', menu.getDelimiter());
    }

    @Test
    public void setDelimiter2() {
        menu.setDelimiter('d');
        assertEquals('d', menu.getDelimiter());
    }
}