package main.test.tree;

/**
 * @ClassName ArrBinaryTreeTest
 * @Description Ë³Ğò´æ´¢¶ş²æÊ÷²âÊÔ
 * @Author Administrator
 * @Date 2020/12/28 13:45
 * @Version 1.0
 */
public class ArrBinaryTreeTest {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = {1, 3, 6, 8, 10, 14};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
        System.out.println("+++++++ÖĞĞò±éÀú+++++++");
        arrBinaryTree.midOrder();
        System.out.println("+++++++ºóĞò±éÀú+++++++");
        arrBinaryTree.follOrder();
    }
}
