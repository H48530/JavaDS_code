/**
 * 插入排序
 */
public class InsertSort {
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

    public static void insertSort2(long[] array) {
        for (int i = 1; i < array.length; i++) {
            long t = array[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) / 2;
                if (t >= array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = t;
        }
    }
}
