package Day0320;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        System.out.println(linkedList);
        System.out.println(linkedList.size);
        linkedList.add(0, "A");
        linkedList.add(0, "B");
        linkedList.add(2, "C");
        linkedList.add(8, "C");
        System.out.println(linkedList);
        System.out.println(linkedList.size);
        System.out.println(linkedList.isEmpty());
        linkedList.clear();
//        MyIterator iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            String e = iterator.next();
//            System.out.println(e);
//        }
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println(linkedList.remove(2));   // D
        System.out.println(linkedList.remove(2));   // C
        System.out.println(linkedList.remove(0));   // B
        System.out.println(linkedList.remove(0));   // A
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println(linkedList.get(1));  // B
        System.out.println(linkedList.set(1, "b")); // B
        System.out.println(linkedList); // [A, b, C]


        System.out.println(linkedList);
        System.out.println(linkedList.size);






//        linkedList.add("A");
//        linkedList.add("B");
//        linkedList.add("C");
//        System.out.println(linkedList); // [A, B, C]

//        linkedList.add(0, "A");
//        linkedList.add(0, "B");
//        linkedList.add(2, "C");
//        System.out.println(linkedList); // [A, B, C]
//        linkedList.add(2, "D");
//        System.out.println(linkedList.size());  // 3
//        System.out.println(linkedList.isEmpty());   // false
//        System.out.println("======================");
//        linkedList.clear();
//        System.out.println(linkedList); // []
//        System.out.println(linkedList.size());  // 0
//        System.out.println(linkedList.isEmpty());   // true
//        System.out.println("======================");
//        System.out.println(linkedList); // [B, A, D, C]
//        System.out.println(linkedList.size());  // 4
//        System.out.println(linkedList.isEmpty());   // false
//        System.out.println("======================");
//        System.out.println(linkedList.remove(2));   // D
//        System.out.println(linkedList.remove(2));   // C
//        System.out.println(linkedList.remove(0));   // B
//        System.out.println(linkedList.remove(0));   // A
//        System.out.println(linkedList); // []
//        System.out.println(linkedList.size());  // 0
//        System.out.println(linkedList.isEmpty());   // true
//        System.out.println("======================");
//        linkedList.add("A");
//        linkedList.add("B");
//        linkedList.add("C");
//        System.out.println(linkedList.get(1));  // B
//        System.out.println(linkedList.set(1, "b")); // B
//        System.out.println(linkedList); // [A, b, C]
    }
}
