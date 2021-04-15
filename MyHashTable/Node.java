package HashTable;

/**
 *
 */
public class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + key +
                ", next=" + next +
                '}';
    }
}
