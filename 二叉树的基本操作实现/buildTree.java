/**
 *
 */
public class buildTree {
    public static TreeNode buildTree1() {
        // 让大家练习前中后序的树
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');
        TreeNode i = new TreeNode('i');
        TreeNode j = new TreeNode('j');
        TreeNode k = new TreeNode('k');
        TreeNode l = new TreeNode('l');
        TreeNode m = new TreeNode('m');
        TreeNode n = new TreeNode('n');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.right = h;
        f.left = i;
        f.right = j;
        g.right = k;
        h.right = l;
        j.left = m;
        m.left = n;

        return a;
    }

    public static TreeNode buildTree2() {
        // 构建课件上的树
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

        return a;
    }
}
