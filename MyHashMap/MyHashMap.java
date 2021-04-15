package MyHashMap;

/**
 *
 */
public class MyHashMap {
    private Node[] array;
    private int size;

    public MyHashMap() {
        array = new Node[16];
        size = 0;
    }

    //计算出index
    private int indexOf(String key) {
        int hash = key.hashCode();
        int h = hash ^ (hash >> 16);
        //前提：array.length.一定2的多少次方，16/32/64/128.

        return h & (array.length - 1);
    }

    //get
    public Integer get(String key) {
        int index = indexOf(key);
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    //getOrDefault
    public Integer getOrDefault(String key, Integer value) {
        int index = indexOf(key);
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return value;
    }

    //put
    public Integer put(String key, Integer value) {
        int index = indexOf(key);
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                Integer oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }

        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        //考虑是否扩容问题
        if ((double) size / array.length > 0.5) {
            grow();
        }
        return null;
    }

    private void grow() {
        Node[] newArray = new Node[array.length * 2];

        for (Node head : array) {
            Node cur = head;
            while (cur != null) {
                int index = indexOf(cur.key) % newArray.length;
                Node next = cur.next;

                cur.next = newArray[index];
                newArray[index] = cur;

                cur = next;
            }
        }
        array = newArray;
    }

}
