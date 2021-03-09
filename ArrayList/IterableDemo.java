import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class IterableDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //具有迭代能力的
        Iterable<String> r1 = list;

        //迭代器
        Iterator<String> it = r1.iterator();

        //任何具有迭代能力的，都可以用foreach遍历
//        for (String s : list) {
//            System.out.println(s);
//        }

        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }

}
