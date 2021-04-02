import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class PriorityQueueDemo {
    static class IntegerComparator implements Comparator<Integer> {
        //返回较大的
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = new IntegerComparator();
        System.out.println(comparator.compare(8, 2));   // < 0

        Queue<Integer> queue = new PriorityQueue<>(comparator);

        queue.add(9);
        queue.add(5);
        queue.add(2);
        queue.add(7);

        System.out.println(queue.element());
    }
}
