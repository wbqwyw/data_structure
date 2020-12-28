package main.test.tree;

/**
 * @ClassName BinaryTree
 * @Description 二叉树
 * @Author Administrator
 * @Date 2020/12/28 10:27
 * @Version 1.0
 */
public class BinaryTree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public Node preFind(int no) {
        if (root != null) {
        }
        return null;
    }

    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        }
    }

    public void follOrder() {
        if (root != null) {
            this.root.follOrder();
        }
    }

    public void midOrder() {
        if (root != null) {
            this.root.midOrder();
        }
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.no == no) {
                root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("空树");
        }
    }
}

class Node {
    public int no;
    public String name;
    public Node left;
    public Node right;
    public int leftType;
    public int rightType;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
    }

    public Node preFind(int no) {
        if (this.no == no) {
            return this;
        }
        Node node = null;
        if (this.left != null) {
            node = this.left.preFind(no);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preFind(no);
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后续遍历
     */
    public void follOrder() {
        if (this.left != null) {
            this.left.follOrder();
        }
        if (this.right != null) {
            this.right.follOrder();
        }
        System.out.println(this);
    }


}
