import java.util.Arrays;

/**
 *
 */
public class MergeSort {
    public static void mergeSort(long[] array) {
        mergeSortRange(array, 0, array.length);
    }

    private static void mergeSortRange(long[] array, int from, int to) {
        if (to - from <= 1) {
            return;
        }
        int mid = (to + from) / 2;
        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid, to);

        merge(array, from, mid, to);
    }

    private static void merge(long[] array, int from, int mid, int to) {
        int size = to - from;
        long[] array2 = new long[size];

        int k1 = from;
        int k2 = mid;
        int k3 = 0;

        while (k1 < mid && k2 < to) {
            if (array[k1] <= array[k2]) {
                array2[k3++] = array[k1++];
            } else {
                array2[k3++] = array[k2++];
            }
        }
        while (k1 < mid) {
            array2[k3++] = array[k1++];
        }
        while (k2 < to) {
            array2[k3++] = array[k2++];
        }
        for (int i = 0; i < size; i++) {
            array[from + i] = array2[i];
        }
    }

    public static void main(String[] args) {
        long[] array = {9, 5, 2, 7, 3, 6, 1, 4, 0, 8};
        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }
}
