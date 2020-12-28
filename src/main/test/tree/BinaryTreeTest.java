package main.test.tree;

/**
 * @ClassName BinaryTreeTest
 * @Description ¶ş²æÊ÷²âÊÔ
 * @Author Administrator
 * @Date 2020/12/28 10:39
 * @Version 1.0
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node(1, "ËÎ½­");
        Node node2 = new Node(2, "ÎâÓÃ");
        Node node3 = new Node(3, "Â¬¿¡Òå");
        Node node4 = new Node(4, "ÀîåÓ");
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        binaryTree.setRoot(node1);
        binaryTree.preOrder();
        System.out.println("+++++++++++É¾³ı+++++++++");
        binaryTree.delNode(4);
        binaryTree.preOrder();
    }
}
