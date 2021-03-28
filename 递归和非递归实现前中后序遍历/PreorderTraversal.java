import java.util.Stack;

/**
 *
 */
public class PreorderTraversal {

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    public void preOder1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
    }

}
