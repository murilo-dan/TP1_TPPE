import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void setDelimiter() {
        assertEquals('b', Menu.setDelimiter());
    }
}