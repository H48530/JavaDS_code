package Day0405;

/**
 *
 */
public class Sort {
    public static void insertSort(long[] array) {
        for (int i = 1; i < array.length; i++) {
            long t = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > t; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = t;
        }
    }

    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    private static void quickSortRange(long[] array, int from, int to) {

        int size = from - to;
        if (size <= 1) {
            return;
        }

        int pivotIndex = partition(array, from, to);

        quickSortRange(array, from, pivotIndex - 1);
        quickSortRange(array, pivotIndex + 1, to);
    }

    private static int partition(long[] array, int from, int to) {
        int left = from;
        int right = to;

        long pivot = array[from];

        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            long e = array[left];
            array[left] = array[right];
            array[right] = e;
        }
        array[left] = pivot;
        return left;
    }

    void partitionOddEven(long[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            while (left <= right && array[right] % 2 == 0) {
                right--;
            }
            while (left <= right && array[left] % 2 == 1) {
                left++;
            }
            if (left <= right) {
                long e = array[left];
                array[left] = array[right];
                array[right] = e;
            }
        }
    }
}
