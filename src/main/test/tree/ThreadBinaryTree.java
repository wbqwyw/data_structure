package main.test.tree;

/**
 * @ClassName ThreadBinaryTree
 * @Description 线索化二叉树
 * @Author Administrator
 * @Date 2020/12/28 14:54
 * @Version 1.0
 */
public class ThreadBinaryTree {
    private Node root;
    private Node pre = null;


    public ThreadBinaryTree(Node root) {
        this.root = root;
    }

    public ThreadBinaryTree() {
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void midThreadNode() {
        this.midThreadNode(root);
    }

    public void follList() {
        follList(root);
    }

    public void follList(Node node) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        if (node.leftType != 1) {
            follList(node.left);
        }
        if (node.rightType != 1) {
            follList(node.right);
        }
        System.out.println(node);
    }

    public void preList2() {
        preList2(root);
    }

    public void preList2(Node node) {
        if (node == null) {
            System.out.println("树为空");
            return;
        }
        System.out.println(node);
        if (node.leftType != 1) {
            preList2(node.left);
        }
        if (node.right != null && node.rightType != 1) {
            preList2(node.right);
        }
    }

    public void preList() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        Node node = root;
        //node.right!=null 是为了有个结束，不然死循环
        while (node != null && node.right != null) {
            System.out.println(node);
            while (node.leftType != 1) {
                node = node.left;
                System.out.println(node);
            }
            if (node.rightType == 1) {
                node = node.right;
            }
        }
    }

    public void midList2() {
        midList2(root);
    }

    public void midList2(Node node) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        if (node.leftType != 1) {
            midList2(node.left);
        }
        System.out.println(node);
        if (node.right != null && node.rightType != 1) {
            midList2(node.right);
        }
    }

    public void midList() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        Node node = root;
        while (node != null) {
            while (node.leftType != 1) {
                node = node.left;
            }
            System.out.println(node);
            //也可以这么写if (node.rightType == 1) {  只要证明有右节点就行
            //if (node.right != null && node.right.rightType == 0)
            if (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }

    }

    public void midThreadNode(Node node) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        if (node.left != null) {
            midThreadNode(node.left);
        }
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        if (node.right != null) {
            midThreadNode(node.right);
        }
    }

    /**
     * 前序
     */
    public void preThreadNode() {
        this.preThreadNode(root);
    }

    public void preThreadNode(Node node) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        if (node.left != null && node.leftType == 0) {
            preThreadNode(node.left);
        }
        if (node.right != null && node.rightType == 0) {
            preThreadNode(node.right);
        }
    }

    /**
     * 后序
     */
    public void follThreadNode() {
        this.follThreadNode(root);
    }

    public void follThreadNode(Node node) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        if (node.left != null) {
            follThreadNode(node.left);
        }
        if (node.right != null) {
            follThreadNode(node.right);
        }
        if (node.left == null && node.leftType == 0) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null && pre.rightType == 0) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
    }
}
