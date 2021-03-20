package Day0320;

public class MyLinkedList {
    public MyListNode head;
    public MyListNode last;
    public int size;

    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public boolean add(String e) {
        MyListNode node = new MyListNode(e);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            throw new RuntimeException("下标不合法！");
        }
        MyListNode node = new MyListNode(e);
        if (head == null) {
            head = node;
            last = node;
        } else if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;
        } else if (index == size()) {
            last.next = node;
            node.prev = last;
            last = node;
        } else {
            MyListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            MyListNode next = cur.next;

            node.prev = cur;
            node.next = next;
            cur.next = node;
            next.prev = node;
        }
        size++;
    }

    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException("下标不合法！");
        }
        String e;
        if (size() == 1) {
            e = head.val;
            head = null;
            last = null;
        } else if (index == 0) {
            e = head.val;
            head = head.next;
            head.prev = null;
        } else if (index == size() - 1) {
            e = last.val;
            last = last.prev;
            last.next = null;
        } else {
            MyListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            e = cur.val;
            MyListNode prev = cur.prev;
            MyListNode next = cur.next;
            prev.next = next;
            next.prev = prev;
        }
        size--;
        return e;
    }

    public boolean remove(String e) {
        int i = indexOf(e);
        if (i < 0) {
            return false;
        }
        remove(i);
        return true;

    }

    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException("下标不合法");
        }
        MyListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public String set(int index, String e) {
        if (index < 0 || index >= size()) {
            throw new RuntimeException("下标不合法");
        }
        String old;
        MyListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        old = cur.val;
        cur.val = e;
        return old;
    }

    public int indexOf(String e) {

        int count = 0;
        for (MyListNode cur = head; cur != null; cur = cur.next) {

            if (cur.val.equals(e)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public int lastIndexOf(String e) {
        int count = 0;
        for (MyListNode cur = last; cur != null; cur = cur.prev) {

            if (cur.val.equals(e)) {
                return count;
            }
            count--;
        }
        return -1;
    }

    public boolean contains(String e) {
        return indexOf(e) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        last = null;
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        MyListNode cur = head;
        StringBuilder str = new StringBuilder();
        while (cur != null) {
            str.append(cur.val);
            str.append(" ");
            cur = cur.next;
        }

        return str.toString();
    }

    MyIterator iterator() {
        return new MyIterator(head);
    }

//    public MyListNode head;
//    public MyListNode last;
//    public int size;
//
//    public MyLinkedList() {
//        head = null;
//        last = null;
//        size = 0;
//    }
//
//    public boolean add(String e) {
//        MyListNode node = new MyListNode(e);
//        if (head == null) {
//            head = last = node;
//        } else {
//            node.prev = last;
//            last.next = node;
//            last = node;
//        }
//
//        size++;
//
//        return true;
//    }
//
//    public void add(int index, String e) {
//        if (index < 0 || index > size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//
//        MyListNode node = new MyListNode(e);
//        if (head == null) {
//            head = last = node;
//        } else if (index == 0) {
//            node.next = head;
//            head.prev = node;
//            head = node;
//        } else if (index == size()) {
//            node.prev = last;
//            last.next = node;
//            last = node;
//        } else {
//            MyListNode prev = head;
//            for (int i = 0; i < index - 1; i++) {
//                prev = prev.next;
//            }
//            MyListNode next = prev.next;
//
//            node.prev = prev;
//            node.next = next;
//            prev.next = node;
//            next.prev = node;
//        }
//
//        size++;
//    }
//
//    public String remove(int index) {
//        if (index < 0 || index >= size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//
//        String e;
//        if (size() == 1) {
//            e = head.val;
//            head = last = null;
//        } else if (index == 0) {
//            e = head.val;
//            head = head.next;
//            head.prev = null;
//        } else if (index == size() - 1) {
//            e = last.val;
//            last = last.prev;
//            last.next = null;
//        } else {
//            MyListNode toDel = head;
//            for (int i = 0; i < index; i++) {
//                toDel = toDel.next;
//            }
//            e = toDel.val;
//            MyListNode prev = toDel.prev;
//            MyListNode next = toDel.next;
//
//            prev.next = next;
//            next.prev = prev;
//        }
//
//        size--;
//
//        return e;
//    }
//
//    public boolean remove(String e) {
//        int index = indexOf(e);
//        if (index < 0) {
//            return false;
//        }
//
//        remove(index);
//        return true;
//    }
//
//    // O(n)
//    public String get(int index) {
//        if (index < 0 || index >= size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//
//        MyListNode node = head;
//        for (int i = 0; i < index; i++) {
//            node = node.next;
//        }
//
//        return node.val;
//    }
//
//    // O(n)
//    public String set(int index, String e) {
//        if (index < 0 || index >= size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//
//        MyListNode node = head;
//        for (int i = 0; i < index; i++) {
//            node = node.next;
//        }
//
//        String oldE = node.val;
//        node.val = e;
//        return oldE;
//    }
//
//    // O(n)
//    public int indexOf(String e) {
//        // 遍历查找
//        int i = 0;
//        for (MyListNode cur = head; cur != null; cur = cur.next) {
//            if (cur.val.equals(e)) {
//                return i;
//            }
//
//            i++;
//        }
//
//        return -1;
//    }
//
//    public int lastIndexOf(String e) {
//        int i = size() - 1;
//        for (MyListNode cur = last; cur != null; cur = cur.prev) {
//            if (cur.val.equals(e)) {
//                return i;
//            }
//            i--;
//        }
//
//        return -1;
//    }
//
//    public boolean contains(String e) {
//        return indexOf(e) >= 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    public void clear() {
//        head = null;
//        last = null;
//        size = 0;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[");
//        for (MyListNode cur = head; cur != null; cur = cur.next) {
//            sb.append(cur.val);
//            if (cur != last) {
//                sb.append(", ");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    MyIterator iterator() {
//        return new MyIterator(this.head);
//    }
}
