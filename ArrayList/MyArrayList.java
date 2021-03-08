package ArrayList;

import java.util.Arrays;

/**
 * 模拟实现自己的ArrayList
 */
public class MyArrayList implements MyList {
    private Integer[] array;
    private int size;

    public MyArrayList() {
        array = new Integer[1];
        size = 0;
    }

    //判断是否满了
    private void isFull() {
        if (size < array.length) {
            return;
        }
//        Integer[] arr = new Integer[array.length * 2];
////        arr = Arrays.copyOf(array, array.length);
////        this.array = arr;
//        for (int i=0;i<array.length;i++){
//            arr[i]=array[i];
//        }
//        this.array = arr;
        this.array = Arrays.copyOf(this.array, this.array.length * 2);
    }


    @Override
    public boolean add(Integer e) {
        isFull();
        array[size] = e;
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        isFull();
        if (index < 0 || index > size()) {
            // 下标不合法
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int from = size() - 1; from >= index; from--) {
            array[from + 1] = array[from];
        }
        array[index] = e;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size()) {
            // 下标不合法
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Integer e = array[index];
        for (int from = index + 1; from < size; from++) {
            array[from - 1] = array[from];
        }
        array[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {

        int i = indexOf(e);
        if (i < 0) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size()) {
            // 下标不合法
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index >= size()) {
            // 下标不合法
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(Integer e) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        Integer[] toShow = Arrays.copyOf(array, size);
        return Arrays.toString(toShow);
    }
}
