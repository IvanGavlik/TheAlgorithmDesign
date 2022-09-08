package fundamentals.stacksAndQueues.stackWithMax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackWithMaxTest {

    @Test
    public void testMaxBase() {
        StackWithMax<Integer> stack = new StackWithMax<>();
        stack.push(new Node<>(0));
        stack.push(new Node<>(1));
        stack.push(new Node<>(2));

        Assertions.assertEquals(2, stack.getMax().getValue());
        Assertions.assertNull( stack.getMax().getNext());
    }

    @Test
    public void testMaxInTheMiddle() {
        StackWithMax<Integer> stack = new StackWithMax<>();
        stack.push(new Node<>(0));
        stack.push(new Node<>(5));
        stack.push(new Node<>(2));

        Assertions.assertEquals(5, stack.getMax().getValue());
        Assertions.assertNull( stack.getMax().getNext());
    }

    @Test
    public void testMaxNull() {
        Assertions.assertNull(new StackWithMax<>().getMax());
    }
}
