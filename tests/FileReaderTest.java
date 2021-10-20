import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {

    private String path;

    @Test
    public void readFile() {
        path = "C:\\Users\\analu\\Downloads\\analysisTime.out";

        assertEquals(true, FileReader.readFile(path) instanceof List);
    }
}