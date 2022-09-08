package fundamentals.stacksAndQueues.stackWithMax;

import java.util.Objects;

public class StackWithMax<T extends Comparable<T>>{

    private Node<T> root;
    private Node<T> max;

    public StackWithMax() {}

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
        this.setMax(item);
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

    private void setMax(Node<T> node) {
        Node<T> current = this.getMax();
        if (current == null) {
            this.max = node;
            return;
        }
        if (node.getValue().compareTo(current.getValue()) >= 1) {
            this.max = new Node<>(node.getValue(), null);
        }
    }

    public Node<T> getMax() {
        return this.max;
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
