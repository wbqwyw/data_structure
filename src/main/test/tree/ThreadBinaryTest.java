package main.test.tree;

/**
 * @ClassName ThreadBinaryTest
 * @Description 线索化二叉树测试
 * @Author Administrator
 * @Date 2020/12/28 15:02
 * @Version 1.0
 */
public class ThreadBinaryTest {
    public static void main(String[] args) {
        Node root = new Node(1, "tom");
        Node node2 = new Node(3, "jack");
        Node node3 = new Node(6, "smith");
        Node node4 = new Node(8, "mary");
        Node node5 = new Node(10, "king");
        Node node6 = new Node(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        //测试中序线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
//        threadBinaryTree.preThreadNode();
        threadBinaryTree.midThreadNode();
//        threadBinaryTree.follThreadNode();

        //测试: 以10号节点测试
        Node leftNode = node5.left;
        Node rightNode = node5.right;
//        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
//        System.out.println("10号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
//        threadBinaryTree.follList(); // 8, 3, 10, 1, 14, 6
//        threadBinaryTree.midList();// 8, 3, 10, 1, 14, 6
        threadBinaryTree.midList2();// 8, 3, 10, 1, 14, 6
//        threadBinaryTree.preList(); // 1, 3, 8, 10, 6, 14
//        threadBinaryTree.preList2(); // 1, 3, 8, 10, 6, 14
    }
}
