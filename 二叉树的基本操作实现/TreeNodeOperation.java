/**
 * 二叉树的基本操作
 */
public class TreeNodeOperation {

    //前序遍历
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%c  ", root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.printf("%c  ", root.val);
        inOrderTraversal(root.right);
    }

    //后序遍历
    public static void posteOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        posteOrderTraversal(root.left);
        posteOrderTraversal(root.right);
        System.out.printf("%c  ", root.val);
    }

    //遍历求结点的个数
    static int size = 0;

    public static void getSize1(TreeNode root) {
        if (root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 汇集思想求结点的个数
    public static int getSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left + right + 1;
    }

    // 遍历求叶子结点的个数
    static int leafSize = 0;

    public static void getLeafSize1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 汇集思想求叶子结点的个数
    public static int getLeafSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = getLeafSize2(root.left);
        int right = getLeafSize2(root.right);
        return left + right;
    }

    //  求第k层结点个数
    public static int getLeavelSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        int left = getLeavelSize(root.left, k - 1);
        int right = getLeavelSize(root.right, k - 1);
        return left + right;
    }


    // 求二叉树的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Integer.max(left, right) + 1;
    }

    //是否存在结点为e的结点
    public static boolean contains(TreeNode root, int e) {
        if (root == null) {
            return false;
        }
        if (root.val == e) {
            return true;
        }
        if (contains(root.left, e)) {
            return true;
        }
        return contains(root.right, e);
    }

    //是否存在结点为e的结点，返回其结点位置
    public static TreeNode nodeOf(TreeNode root, int e) {
        if (root == null) {
            return null;
        }
        if (root.val == e) {
            return root;
        }
        TreeNode r = nodeOf(root.left, e);
        if (r != null) {
            return r;
        }
        return nodeOf(root.right, e);
    }

    // 判断 node 在不在以 root 为根的树中，node 一定不是 null
    public static boolean containsNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean r = containsNode(root.left, node);
        if (r) {
            return true;
        }
        return containsNode(root.right, node);
    }


    // 判断 node 在不在以 root 为根的树中，node 一定不是 null
    public static void main(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();
        TreeNode node1 = new TreeNode('a');
        System.out.println(containsNode(root1, root1));
        System.out.println(containsNode(root1, root2));
        System.out.println(containsNode(root1, node1));
        System.out.println(containsNode(root2, node1));
        System.out.println(containsNode(node1, node1));
    }

    //是否存在结点为e的结点，返回其结点位置
    public static void main7(String[] args) {
        TreeNode root1 = buildTree.buildTree1();

        System.out.println(nodeOf(root1, '1'));
        System.out.println(nodeOf(root1, 'c'));
        System.out.println(nodeOf(root1, 'e'));
    }


    //是否存在结点为e的结点
    public static void main6(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();

        System.out.println(contains(root1, '1'));
        System.out.println(contains(root1, 'c'));
        System.out.println(contains(root1, 'z'));
    }

    //二叉树高度
    public static void main5(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();
        System.out.println(getHeight(root1));
        System.out.println(getHeight(root2));
    }

    //求解二叉树第k层有几个结点
    public static void main4(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();

        System.out.println(getLeavelSize(root1, 2));
        System.out.println(getLeavelSize(root1, 4));
        System.out.println(getLeavelSize(root2, 1));
        System.out.println(getLeavelSize(root2, 3));
        System.out.println(getLeavelSize(root2, 4));
    }

    //求解叶子结点个数
    public static void main3(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();
        System.out.println(getLeafSize2(root1));
        System.out.println(getLeafSize2(root2));

        getLeafSize1(root1);
        System.out.println(leafSize);
        getLeafSize1(root2);
        System.out.println(leafSize);
    }

    //测试求解节点数
    public static void main2(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();

        System.out.println(getSize2(root1));
        System.out.println(getSize2(root2));
        getSize1(root1);
        System.out.println(size);
        getSize1(root2);
        System.out.println(size);
        System.out.println("===========");
        size = 0;
        getSize1(root1);
        System.out.println(size);
        size = 0;
        getSize1(root2);
        System.out.println(size);
    }

    //前中后序遍历
    public static void main1(String[] args) {
        TreeNode root1 = buildTree.buildTree1();
        TreeNode root2 = buildTree.buildTree2();
        preOrderTraversal(root1);
        System.out.println();
        inOrderTraversal(root1);
        System.out.println();
        posteOrderTraversal(root1);
        System.out.println();
        System.out.println("================================");
        preOrderTraversal(root2);
        System.out.println();
        inOrderTraversal(root2);
        System.out.println();
        posteOrderTraversal(root2);
    }
}
