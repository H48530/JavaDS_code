/**
 *希尔排序
 */
public class ShellSort {
    public static void shellSort(long[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(long[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            long t = array[i];
            int j = i - gap;
            for (; j >= 0 && array[j] > t; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = t;
        }
    }
}
