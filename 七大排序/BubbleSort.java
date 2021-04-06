import java.util.Arrays;

/**
 *
 */
public class BubbleSort {
    public static void bubbleSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Swap.swap(array, j, j + 1);
                    flg = false;
                }
            }
            if (flg){
                break;
            }
        }
    }
    public static void main(String[] args) {
        long[] arr = {1, 2, 13, 24, 43, 5, 65, 7, 878, 23, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
