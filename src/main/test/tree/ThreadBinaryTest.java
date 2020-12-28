package main.test.tree;

/**
 * @ClassName ThreadBinaryTest
 * @Description ����������������
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

        //����������������Ҫ�ݹ鴴��, ���ڼ򵥴���ʹ���ֶ�����
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        //��������������
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
//        threadBinaryTree.preThreadNode();
        threadBinaryTree.midThreadNode();
//        threadBinaryTree.follThreadNode();

        //����: ��10�Žڵ����
        Node leftNode = node5.left;
        Node rightNode = node5.right;
//        System.out.println("10�Ž���ǰ������� =" + leftNode); //3
//        System.out.println("10�Ž��ĺ�̽����=" + rightNode); //1

        //��������������������ʹ��ԭ���ı�������
        //threadBinaryTree.infixOrder();
        System.out.println("ʹ���������ķ�ʽ���� ������������");
//        threadBinaryTree.follList(); // 8, 3, 10, 1, 14, 6
//        threadBinaryTree.midList();// 8, 3, 10, 1, 14, 6
        threadBinaryTree.midList2();// 8, 3, 10, 1, 14, 6
//        threadBinaryTree.preList(); // 1, 3, 8, 10, 6, 14
//        threadBinaryTree.preList2(); // 1, 3, 8, 10, 6, 14
    }
}
