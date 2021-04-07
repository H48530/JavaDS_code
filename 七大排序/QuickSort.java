import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class QuickSort {
    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    private static void quickSortRange(long[] array, int from, int to) {
        int size = to - from + 1;
        if (size <= 1) {
            return;
        }
        int pivotIndex = partition3(array, from, to);
        quickSortRange(array, from, pivotIndex - 1);
        quickSortRange(array, pivotIndex + 1, to);
    }

    private static int partition(long[] array, int from, int to) {
        int left = from;
        int right = to;
        long poivt = array[from];
        while (left < right) {
            while (left < right && array[right] >= poivt) {
                right--;
            }
            while (left < right && array[left] <= poivt) {
                left++;
            }
            Swap.swap(array, left, right);
        }
        Swap.swap(array, left, from);
        return left;
    }

    private static int partition2(long[] array, int from, int to) {
        int left = from;
        int right = to;
        long pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    private static int partition3(long[] array, int from, int to) {
        long pivot = array[from];
        int s = from + 1;
        for (int i = from + 1; i <= to; i++) {
            if (array[i] < pivot) {
                Swap.swap(array, i, s);
                s++;
            }
        }
        Swap.swap(array, s - 1, from);
        return s - 1;
    }


    public static void main(String[] args) {
        long[] arr = {1, 2, 13, 24, 43, 5, 65, 7, 878, 23, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
