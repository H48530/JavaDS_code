package lianxi;

import java.util.Arrays;
import java.util.Stack;

/**
 * 排序
 */
public class Sort {
    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //冒泡排序
    public static void bubblesort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flg = false;
                }
            }
            if (flg) {
                break;
            }
        }
    }

    //选择排序
    public static void selectsort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = 0;
            for (int j = 1; j < array.length - i - 1; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            swap(array, max, array.length - i - 1);
        }
    }

    //插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int t = array[i];
            for (; j >= 0 && array[j] > t; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = t;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int j = i - gap;
            int t = array[i];
            for (; j >= 0 && array[j] > t; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = t;
        }
    }

    //堆排序
    public static void heapsort(int[] array) {
        creatheap(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - i - 1);
            shiftDown(array, array.length - i - 1, 0);

        }

    }

    private static void creatheap(int[] array) {
        int size = (array.length - 2) / 2;
        for (int i = size; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    //大堆
    private static void shiftDown(int[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }
            int maxIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && array[rightIndex] > array[leftIndex]) {
                maxIndex = rightIndex;
            }
            if (array[maxIndex] < array[index]) {
                return;
            }
            swap(array, index, maxIndex);
            index = maxIndex;
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    private static void quickSortRange(int[] array, int from, int to) {
        int size = to - from + 1;
        if (size <= 1) {
            return;
        }
        int pivot = partition2(array, from, to);
        quickSortRange(array, from, pivot - 1);
        quickSortRange(array, pivot + 1, to);
    }

    private static int partition1(int[] array, int from, int to) {
        int left = from;
        int right = to;
        int p = array[from];
        while (left < right) {
            while (left < right && array[right] >= p) {
                right--;
            }
            while (left < right && array[left] <= p) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, left, from);
        return left;
    }

    private static int partition2(int[] array, int from, int to) {
        int left = from;
        int right = to;
        int p = array[from];
        while (left < right) {
            while (left < right && array[right] >= p) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= p) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = p;
        return left;
    }

    private static int partition3(int[] array, int from, int to) {
        int p = array[from];
        int s = from + 1;
        for (int i = from + 1; i <= to; i++) {
            if (array[i] < p) {
                swap(array, i, s);
                s++;
            }
        }
        swap(array, s - 1, from);
        return s - 1;
    }
    public static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int pivotIndex = partition1(array,left,right);
            stack.push(right);
            stack.push(pivotIndex+1);

            stack.push(pivotIndex-1);
            stack.push(left);
        }

    }

    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortRange(array, 0, array.length);
    }

    private static void mergeSortRange(int[] array, int from, int to) {
        int size = to - from;
        if (size <= 1) {
            return;
        }
        int mid = (to + from) / 2;
        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid, to);

        merge(array, from, mid, to);
    }

    private static void merge(int[] array, int from, int mid, int to) {
        int size = to - from;
        int[] array2 = new int[size];

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
        int[] arr = {1, 2, 13, 24, 43, 5, 65, 7, 878, 23, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
