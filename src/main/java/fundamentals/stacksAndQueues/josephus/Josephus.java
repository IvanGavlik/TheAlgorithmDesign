package fundamentals.stacksAndQueues.josephus;

/**
 N people are in dire straits and agree to the following strategy to reduce the population.
 They arrange themselves in a circle (at positions numbered from 0 to N-1) and proceed around the circle,
 eliminating every Mth person until only one person is left.
 Legend has it that Josephus figured out where to sit to avoid being eliminated.

 Application takes M and N from the command line and prints out the order in which people
 are eliminated (and thus would show Josephus where to sit in the circle)
 */
public class Josephus {

    /**
     *
     * @param step - step size
     * @param n - size of circle form 0 to n - 1
     * @return Return order the order in which people are eliminated
     */
    public Node whereToSit(int step, int n) {
        if (step <= 0) {
            throw new RuntimeException("Step can not be less than 1");
        }
        if (step > n) {
            throw new RuntimeException("Step can not be less than n");
        }
        Node<Integer> root = new Node<>();
        root.setValue(0);
        this.populateNodes(1, n, root);

        int stepStart = 1;
        return whereToSitUtil(root, root, stepStart, step);
    }
    private Node<Integer> whereToSitUtil(Node<Integer> root, Node<Integer> current, int step, int m) {
        if(!root.hasNext()) {
            return root;
        }
        if (step == m) {
            root = removeNode(root, current);
            step = 0;
        }

        if(current.hasNext()) {
            return whereToSitUtil(root, current.getNext(), step + 1 , m);
        } else {
            return whereToSitUtil(root, root, step + 1, m);
        }
    }
    private <T> Node<T> removeNode(Node<T> root, Node<T> remove) {
      if(root == null  || remove == null) {
          return null;
      }
      if(root.equals(remove) && !root.hasNext()) {
          return null;
      }
      if(root.equals(remove) && root.hasNext()) {
          return root.getNext();
      }

      removeNodeUtil(root, root.getNext(), remove);
      return root;
    };
    private <T> void removeNodeUtil(Node<T> previous, Node<T> current, Node<T> remove) {
        if(current.equals(remove)) {
            previous.setNext(current.getNext());
            return;
        } else {
            removeNodeUtil(current, current.getNext(), remove);
        }
    }
    private  <T> void populateNodes(int value, int max, Node<T> node) {
        if (value >= max) {
            return;
        }
        Node n = new Node();
        n.setValue(value);
        node.setNext(n);
        populateNodes(value + 1, max, n);
    }
}

class Node<T> {
    T value;
    Node<T> next;

    public void setValue(T value) {
        this.value = value;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Node) obj).getValue().equals(getValue());
    }
}
