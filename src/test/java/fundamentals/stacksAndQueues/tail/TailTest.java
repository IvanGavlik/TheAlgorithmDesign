package fundamentals.stacksAndQueues.tail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TailTest {

    @Test
    public void last1Lines() {
        Tail t = new Tail(new File("src/test/resources/fundamentals/stacksAndQueues/tail/test.txt"));
        Assertions.assertEquals("Aldus PageMaker including versions of Lorem Ipsum.", t.tail(1)[0]);
    }
}
