package day0309;

/**
 * 链表的练习
 */


class Node {
    int val;//保存元素
    Node next;//指向下一个节点的引用，尾结点的next==null

    @Override
    public String toString() {
        return "Node{" + "val=" + val + '}';
    }
}

public class NodeDemo {
    public static void main(String[] args) {

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Node head = n1;

        //计算链表中元素个数
        //遍历这个链表
//
//        int count = 0;
//        Node cur = head;
//        while (cur != null) {
//
//            System.out.println(cur.val);
//            cur = cur.next;
//            count++;
//        }
//        System.out.println(count);

//        找到最后一个结点
//        Node cur = head;
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//    }
//        //找到倒数第二个结点
//        Node cur = head;
//        while (cur.next.next != null) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);
//    }
        //找到第n个结点

//        int n = 2;
//        Node ncur = head;
//        for (int i = 1; i < n; i++) {
//            ncur = ncur.next;
//        }
//        System.out.println(ncur.val);
        //链表中是否包含某个元素
//        Node cur = head;
//        while (cur != null) {
//            if (cur.val == target) {
//                //找到了
//                System.out.println("找到了");
//            }
//            cur = cur.next;
//        }
//        System.out.println("没找到");

        //插入和删除
        //给定前驱结点后的插入
//        Node prev = n2;
//        Node node = new Node();
//        node.val = 6;
//
//        node.next = prev.next;
//        prev.next = node;

        //给定前驱结点后的删除
//        Node prev = n2;
//        prev.next = prev.next.next;


        //头插
//        Node node=new Node();
//        node.val=12;
//
//        node.next=head;
//        head=node;
//
        //头删
//        if (head == null) {
//            throw new RuntimeException("链表为空");
//        }
//        head = head.next;

        //尾插
        //链表为空，直接插入
//        if (head == null) {
//            Node node = new Node();
//            node.val = 1;
//        }
//        //链表不为空
//        Node last = head;
//        while (last.next != null) {
//            last = last.next;
//        }
//        Node node = new Node();
//        node.val = 12;
//        last.next = node;


        //尾删

        //链表为空，直接插入
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        //链表不为空只有一个节点
        if (head.next == null) {
            head.next=null;
        }
        Node last = head;
        while (last.next.next != null) {
            last = last.next;
        }
        last.next = null;

    }
}
