import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.peek();

            if (node.right == null || node.right == last) {
                // 看作第三次经过
                list.add(node.val);
                last = node;
                stack.pop();
            } else {
                // 第二次经过
                cur = node.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        List<Integer> left = postorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(right);
        list.add(root.val);

        return list;
    }
}
