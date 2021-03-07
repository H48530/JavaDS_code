package day0304;

/**
 * 汉诺塔——递归求解汉诺塔问题
 */
public class Hanoi {

    public static void move(char p1, char p2) {
        System.out.print(p1 + "—>" + p2+" ");
    }

    public static void hanoi(int n, char p1, char p2, char p3) {
        if (n == 1) {
            move(p1, p3);
        } else {
            hanoi(n - 1, p1, p3, p2);
            move(p1, p3);
            hanoi(n - 1, p2, p1, p3);
        }
    }

    public static void main(String[] args) {
        hanoi(1, 'A', 'B', 'C');
        System.out.println();
        hanoi(2, 'A', 'B', 'C');
        System.out.println();
        hanoi(3, 'A', 'B', 'C');
        System.out.println();
        hanoi(4, 'A', 'B', 'C');
        System.out.println();
        hanoi(5, 'A', 'B', 'C');
    }
}
