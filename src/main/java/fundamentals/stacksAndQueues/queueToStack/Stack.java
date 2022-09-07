package fundamentals.stacksAndQueues.queueToStack;


import java.util.Objects;

/**
 * Stack data type that has a constructor
 * for the queue linked-list implementation
 *
 * Stack
 * - push(T item) add an item to the start
 * - T pop() remove item from the top
 */
public class Stack<T> {

    private Node<T> root;

    public Stack(Node<T> node) {
        if(node == null) {
            throw new RuntimeException("Root can not be null");
        }
        this.root = node;
    }

    public Stack(Queue<T> queue) {
        if (queue == null) {
            return;
        }
        this.addToStackFromQueue(queue.dequeue(), queue);
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

    private void addToStackFromQueue(Node<T> node, Queue<T> queue) {
        if (node == null) {
            return;
        }
        this.push(new Node<>(node.getValue(), null));
        this.addToStackFromQueue(queue.dequeue(), queue);
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
}

/**
 * Queue
 * - enqueue(T item) add am item to the end
 * - T dequeue() remove the item from start
 */
class Queue<T> {
    private Node<T> root;
    public Queue(Node<T> root) {
        if(root == null) {
            throw new RuntimeException("Root can not be null");
        }
        this.root = root;
    }
    public void enqueue(Node<T> item) {
        if(item == null) {
            return;
        }
        Node<T> last = iterate();
        if (last == null) {
            root = item;
        } else {
            last.setNext(item);
        }
    }

    public Node<T> dequeue() {
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
        return root;
    }
    private Node<T> iterate() {
        return iterateUtil(this.root, null);
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
        sb.append("Queue: ");
        iterateUtil(this.root, sb);
        if(sb.length() <= 8) {
            sb.append("empty ");
        }
        return sb.toString();
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
