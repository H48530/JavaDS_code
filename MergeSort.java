package Day0405;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(long[] array) {
        mergeSortRange(array, 0, array.length);
    }

    public static void mergeSortRange(long[] array, int from, int to) {
        int size = to - from;
        if (size <= 1) {
            return;
        }
        int mid = from + size / 2;
        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid, to);
        merge(array, from, mid, to);
    }

    private static void merge(long[] array, int from, int mid, int to) {
// 需要额外空间，需要两个区间的大小之和
        int size = to - from;
        long[] array2 = new long[size];

        int k1 = from;  // array
        int k2 = mid;   // array
        int k3 = 0;     // array2

        while (k1 < mid && k2 < to) {
            if (array[k1] <= array[k2]) {   // 加等号是为了保证稳定性
                array2[k3++] = array[k1++];
            } else {
                array2[k3++] = array[k2++];
            }
        }

        // 有一个区间内的元素全部取完了
        if (k1 < mid) {
            // 左边区间还有元素
            while (k1 < mid) {
                array2[k3++] = array[k1++];
            }
        } else {
            // 右边区间还有元素
            while (k2 < to) {
                array2[k3++] = array[k2++];
            }
        }

        // 我们还需要把数据搬回原数组中

        for (int i = 0; i < array2.length; i++) {
            array[from + i] = array2[i];
        }
    }


    public static void main(String[] args) {
        long[] arr = {11,21,32,4,52,6,321,12,12,3,234,234,35};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
