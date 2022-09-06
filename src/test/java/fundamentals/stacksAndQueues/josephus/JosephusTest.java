package fundamentals.stacksAndQueues.josephus;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JosephusTest {

    private Josephus josephus;

    @BeforeEach
    public void init() {
        this.josephus = new Josephus();
    }

    @Test
    public void stepSmallerThanSize() {
        Assertions.assertThrows(RuntimeException.class, () -> josephus.whereToSit(3, 1));
    }

    @Test
    public void stepZeo() {
        Assertions.assertThrows(RuntimeException.class, () -> josephus.whereToSit(0, 3));
    }

    @Test
    public void stepOne() {
        Node node = josephus.whereToSit(1, 3);
        Assertions.assertEquals(2, node.getValue());
        Assertions.assertEquals(null, node.getNext());
    }


    @Test
    public void stepTwo() {
        Node node = josephus.whereToSit(2, 7);
        Assertions.assertEquals(6, node.getValue());
        Assertions.assertEquals(null, node.getNext());
    }
}
