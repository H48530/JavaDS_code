package ArrayList;

/**
 *
 */
public interface MyList {
    //尾插
    boolean add(Integer e);
    //指定位置插入
    void add(int index, Integer e);
    //删除指定位置
    Integer remove(int index);
    //删除指定元素
    boolean remove(Integer e);
    //获取元素
    Integer get(int index);
    //set
    Integer set(int index, Integer e);
    //判断是否包含
    boolean contains(Integer e);
    //从前到后首次遇到
    int indexOf(Integer e);
    //从后到前首次遇到
    int lastIndexOf(Integer e);
    //请空顺序表
    void clear();
    //获取元素个数
    int size();
    //判断size==0？
    boolean isEmpty();

}
