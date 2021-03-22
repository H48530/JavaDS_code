/**
 *
 */
//结点类
class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this(val, null);
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(int v) {
        Node node = new Node(v);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int poll() {
        if (size() == 0) {
            throw new RuntimeException("队列为空");
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return ret;
    }

    public int peek() {
        if (size() == 0) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
