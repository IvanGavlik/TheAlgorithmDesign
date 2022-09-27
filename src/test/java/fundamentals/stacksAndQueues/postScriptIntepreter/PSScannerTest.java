package fundamentals.stacksAndQueues.postScriptIntepreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * Create exact rules for string - delimiter in the start at end in the middle
 */

public class PSScannerTest {
    /**
     * test all data types
     * test file input (exist, not exist, empty, null)
     */

    private PSScanner psScanner;

    @BeforeEach
    private void setUp() {
        psScanner = new PSScanner();
    }

    @Test
    public void simpleStringInput() throws IOException {
        //
        List<PSO> psoList =  psScanner.scan(TestHelper.BASE_PATH + "scanner_simple_string.txt");

        Assertions.assertNotNull(psoList);
        Assertions.assertEquals(1, psoList.size());
        Assertions.assertEquals(new PSO("string", "Example", 1, 1, true).getData(), psoList.get(0).getData());

    }

    @Test
    public void stringInputOneDelimiter() {
//        (Example 4)
    }

    @Test
    public void stringInputMoreDelimiters() {
//        (Example 4 1 2)
    }

    @Test
    public void stringInputDelimiterAtEnd() {
//        (Example 4 )
    }

    @Test
    public void emptyString() {
       // ()
    }

    @Test
    public void stringNotGood() {
        // (
        // )
        // (test 12 1 45
        // 12 32 54) 15
    }
}
