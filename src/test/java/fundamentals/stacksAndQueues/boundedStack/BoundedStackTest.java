package fundamentals.stacksAndQueues.boundedStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoundedStackTest {


    @Test
    public void testBoundedWithNegative() {
        Assertions.assertThrows(RuntimeException.class, () -> new BoundedStack<>(-11));
    }

    @Test
    public void testBoundedWith1() {
        BoundedStack<Integer> stack = new BoundedStack<>(1);
        stack.push(new Node<>(1));
        stack.push(new Node<>(2));
        stack.push(new Node<>(3));

        Assertions.assertEquals(3, stack.pop().getValue());
        Assertions.assertNull(stack.pop());
    }

    @Test
    public void testBoundedWith2AndTwoItems() {
        BoundedStack<Integer> stack = new BoundedStack<>(2);
        stack.push(new Node<>(2));
        stack.push(new Node<>(3));

        Assertions.assertEquals(3, stack.pop().getValue());
        Assertions.assertEquals(2, stack.pop().getValue());
        Assertions.assertNull(stack.pop());
    }

    @Test
    public void testBoundedWith2AndThreeItems() {
        BoundedStack<Integer> stack = new BoundedStack<>(2);
        stack.push(new Node<>(1));
        stack.push(new Node<>(2));
        stack.push(new Node<>(3));

        Assertions.assertEquals(3, stack.pop().getValue());
        Assertions.assertEquals(2, stack.pop().getValue());
        Assertions.assertNull(stack.pop());
    }

    @Test
    public void testBoundedWith3() {
        BoundedStack<Integer> stack = new BoundedStack<>(3);
        stack.push(new Node<>(1));
        stack.push(new Node<>(2));
        stack.push(new Node<>(3));

        Assertions.assertEquals(3, stack.pop().getValue());
        Assertions.assertEquals(2, stack.pop().getValue());
        Assertions.assertEquals(1, stack.pop().getValue());
        Assertions.assertNull(stack.pop());
    }

}
