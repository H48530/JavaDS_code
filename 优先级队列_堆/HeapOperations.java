import java.util.Arrays;

/**
 *
 */
public class HeapOperations {
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }
            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }
            if (array[minIndex] >= array[index]) {
                return;
            }
            int t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            index = minIndex;
        }
    }

    public static void createHeap(int[] array, int size) {
        //最后一个结点为size-1，，最后一个非叶子结点为（size-1-1）/2
        int last = (size - 2) / 2;
        for (int i = last; i >= 0; i--) {
            //向下取整
            heapify(array, size, i);
        }
    }

    public static void main(String[] args) {
        //     int[] array = {100, 3, 50, 4, 7, 60, 70, 8, 9, 12, 13, 65, 66, -1, -1, -1, -3};
//        int size = 13;
//
//        heapify(array, size, 0);
//
//        System.out.println(Arrays.toString(array));
//
        int[] array = {3, 5, 2, 7, 6, 8, 9, 4, 1, 0, 3, 9, 3, -1, 3};
        int size = 13;

        createHeap(array, size);

        System.out.println(Arrays.toString(array));
    }
}
