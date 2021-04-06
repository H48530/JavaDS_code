import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void selectSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            Swap.swap(array, max, array.length - i - 1);
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 13, 24, 43, 5, 65, 7, 878, 23, 1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
