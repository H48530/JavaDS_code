package Day0320;

public class MyIterator {
    public MyListNode cur;

    public MyIterator(MyListNode head) {
        this.cur = head;
    }

    public boolean hasNext() {
        return cur != null;
    }

    public String next() {
        String e = cur.val;
        cur = cur.next;
        return e;
    }
}
