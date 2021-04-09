/**
 *
 */
public class Test {
    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        BSTree tree1 = new BSTree();
        int[] keys1 = {5, 3, 7, 2, 4, 6, 8, 1, 9};
        for (int key : keys1) {
            tree1.insert(key);
        }
        inorder(tree1.root);
        tree1.remove(7);
        //preorder(tree1.root);
        System.out.println();
        inorder(tree1.root);
        System.out.println();
        System.out.println(tree1.find(3));
    }
}
