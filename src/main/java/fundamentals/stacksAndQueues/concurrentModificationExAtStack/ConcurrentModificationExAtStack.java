package fundamentals.stacksAndQueues.concurrentModificationExAtStack;


import java.util.Iterator;
import java.util.Objects;

/**
 * Modify the iterator code in Stack.java to immediately throw a java.util.ConcurrentModificationException if the client modifies the collection (via push() or pop()) during iteration.
 */
public class ConcurrentModificationExAtStack extends RuntimeException {
}

/**
 * Stack data type that has a constructor
 * for the queue linked-list implementation
 *
 * Stack
 * - push(T item) add an item to the start
 * - T pop() remove item from the top
 */
class Stack<T> implements Iterable<T>{

    private Node<T> root;

    private long count = 0;

    public Stack(Node<T> node) {
        if(node == null) {
            throw new RuntimeException("Root can not be null");
        }
        this.root = node;
        this.count += 1;
    }

    public Iterator<T> iterator() {
        return new StackIterator<T>(this, count);
    }

    public void push(Node<T> item) {
        if (item == null) {
            return;
        }
        if (root == null) {
            this.root = item;
        } else {
            Node<T> temRoot = new Node<>(this.root);
            this.root = item;
            this.root.setNext(temRoot);
        }
        this.count += 1;
    }

    public Node<T> pop() {
        if (root == null) {
            return null;
        }
        if (!root.hasNext()) {
            Node<T> tempRoot = new Node<>(this.root);
            this.root = null;
            return tempRoot;
        }
        Node<T> root = new Node<>(this.root);
        Node<T> node = root.getNext();
        this.root = node;
        this.count -= 1;
        return root;
    }

    private Node<T> iterateUtil(Node<T> node, StringBuilder info) {
        if (node == null) {
            return null;
        }
        if (info != null) {
            info.append(node + ", ");
        }
        if(!node.hasNext()) {
            return node;
        }
        return iterateUtil(node.getNext(), info);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        iterateUtil(this.root, sb);
        if(sb.length() <= 7) {
            sb.append("empty ");
        }
        return sb.toString();
    }

    class StackIterator<T> implements Iterator<T> {
        private Node<T> current;
        private Stack stack;
        private long size;

        public StackIterator(Stack stack, long size) {
            this.stack = stack;
            this.current = stack.root;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            if (stack.count != size) {
                throw new ConcurrentModificationExAtStack();
            }
            return current != null && current.getValue() != null;
        }

        @Override
        public T next() {
            if (stack.count != size) {
                throw new ConcurrentModificationExAtStack();
            }
            T value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    public static void main(String[] args) {


     }

}

class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node<T> node) {
        this.value = node.getValue();
        this.next = node.getNext();
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return  value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public String toString() {
        return "Node " + this.value.toString() + " has next " + this.hasNext();
    }
}

