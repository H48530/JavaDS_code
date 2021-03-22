/**
 *
 */
public class MyStack {
    //暂时先不考虑扩容问题
    private int[] array = new int[100];
    private int size = 0;

    public void push(int v) {
        array[size] = v;
        size++;
    }

    public int pop() {
        int ret = array[size - 1];
        size--;
        return ret;
    }

    public int peek() {
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
