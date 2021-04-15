package HashTable;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random(2020412);
        MyHashTable hashTable = new MyHashTable();
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt();
            if (key >= 0 && !hashTable.find(key)) {
                hashTable.insert(key);
            }
        }


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < hashTable.array.length; i++) {
            Node cur = hashTable.array[i];
            int count = 0;
            while (cur != null) {
                count++;
                cur = cur.next;
            }

            if (count < min) {
                min = count;
            }
            if (count > max) {
                max = count;
            }
            sum += count;
        }

        System.out.println(hashTable.size);
        System.out.println(hashTable.array.length);
        System.out.println(max);
        System.out.println(min);
        System.out.println((double) sum / hashTable.array.length);
    }
}
