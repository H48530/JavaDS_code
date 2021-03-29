import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *(https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef)
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}


public class Main {
    public static TreeNode buildTree(List<Character> preorder) {
        if (preorder.isEmpty()) {
            return null;
        }
        char rootval = preorder.remove(0);
        if (rootval == '#') {
            return null;
        }
        TreeNode root = new TreeNode(rootval);
        root.left = buildTree(preorder);
        root.right = buildTree(preorder);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            char[] p = s.toCharArray();

            List<Character> list = new ArrayList<>();
            for (char c : p) {
                list.add(c);
            }

            TreeNode root = buildTree(list);

            inorder(root);

            System.out.println();
        }
    }
}
