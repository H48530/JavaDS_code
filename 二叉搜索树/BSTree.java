/**
 *
 */
public class BSTree {
    public Node root;

    public BSTree() {
        this.root = null;
    }

    //查找
    public boolean find(int key) {
        if (root == null) {
            return false;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return true;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return false;
    }

    //插入
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.key == key) {
                throw new RuntimeException("");
            } else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        if (parent.key < key) {
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    //删除
    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.key == key) {
                //删除
                removeNode(parent, cur);
                return true;
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    //删除操作
    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node goat = cur.right;
            Node goatParent = cur;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            }
            //替换
            cur.key = goat.key;
            //删除
            if (goatParent == cur) {
                goatParent.right = goat.right;
            } else {
                goatParent.left = goat.right;
            }
        }
    }

}
