package fundamentals.stacksAndQueues.queueToStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {

    private Node<Integer> root;

    @BeforeEach
    public void init() {
        this.root = new Node<>(0);
    }

    @Test
    public void queueToStack() {
        Queue<Integer> queue = new Queue<>(root);
        queue.enqueue(new Node<>(1));
        queue.enqueue(new Node<>(2));

        Stack<Integer> stackFromQueue = new Stack(queue);
        Node<Integer> firstOnStack = stackFromQueue.pop();
        Assertions.assertEquals(2, firstOnStack.getValue());
        Assertions.assertTrue(firstOnStack.hasNext());

        Node<Integer> secondOnStack = stackFromQueue.pop();
        Assertions.assertEquals(1, secondOnStack.getValue());
        Assertions.assertTrue(secondOnStack.hasNext());

        Assertions.assertEquals(firstOnStack.getNext(), secondOnStack);

        Node<Integer> thirdOnStack = stackFromQueue.pop();
        Assertions.assertEquals(0, thirdOnStack.getValue());
        Assertions.assertFalse(thirdOnStack.hasNext());

        Assertions.assertEquals(secondOnStack.getNext(), thirdOnStack);
    }
}
