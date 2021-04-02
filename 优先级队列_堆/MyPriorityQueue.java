/**
 *
 */
public class MyPriorityQueue {
    //不考虑扩容
    private String[] array = new String[1000];
    private int size = 0;

    public void add(String e) {
        //尾插，然后向上调整
        array[size++] = e;
        shiftUP(size - 1);

    }

    private void shiftUP(int index) {
        while (true) {
            if (index == 0) {
                return;
            }
            int parentIndex = (index - 1) / 2;
            int cmp = array[parentIndex].compareTo(array[index]);
            if (cmp <= 0) {
                return;
            }
            String t = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = t;

            index = parentIndex;
        }
    }

    public String remove() {
        //将首元素拿出来，并将最后一个元素放在队首，然后向下调整。
        String s = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(0);
        return s;
    }

    private void shiftDown(int index) {
        int cmp;
        while (2 * index + 1 < size) {
            int minIndex = 2 * index + 1;
            if (minIndex + 1 < size) {
                cmp = array[minIndex + 1].compareTo(array[minIndex]);
                if (cmp < 0) {
                    minIndex++;
                }
            }
            cmp = array[index].compareTo(array[minIndex]);
            if (cmp <= 0) {
                return;
            }
            String t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;
            index = minIndex;

        }
    }

    public String element() {
        return array[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();

        // A < B < C < D

        queue.add("C");

        queue.add("B");
        queue.add("A");
        queue.add("D");
        System.out.println(queue.remove()); // A
        System.out.println(queue.remove()); // B
        System.out.println(queue.remove()); // C
        System.out.println(queue.remove()); // D

    }
}
