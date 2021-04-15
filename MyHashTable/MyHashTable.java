package HashTable;

/**
 *
 */
public class MyHashTable {
    //存头结点的数组
    Node[] array;
    int size;

    public MyHashTable() {
        array = new Node[11];
        size = 0;
    }

    //冲突因子
    private double LOAD_FACTOR = 0.75;

    //插入——头插
    public boolean insert(int key) {
        if (find(key)) {
            return false;
        }
        int index = key % array.length;

        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;
        size++;
        if ((double) size / array.length > LOAD_FACTOR) {
            grow();
        }
        return true;
    }

    //扩容
    //2倍扩容
    private void grow() {
        Node[] newArray = new Node[array.length * 2];

        for (Node head : array) {
            Node cur = head;
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node next = cur.next;

                cur.next = newArray[index];
                newArray[index] = cur;

                cur = next;
            }
        }
        array = newArray;
    }

    //删除
    public boolean remove(int key) {
        int index = key % array.length;
        Node cur = array[index];
        Node prev = null;
        while (cur != null) {
            if (key == cur.key) {
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    array[index] = array[index].next;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    //查找
    public boolean find(int key) {
        int index = key % array.length;

        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return true;
            }
        }
        return false;
    }
}
