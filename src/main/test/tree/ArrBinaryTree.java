package main.test.tree;

/**
 * @ClassName ArrBinaryTree
 * @Description 顺序存储二叉树
 * @Author Administrator
 * @Date 2020/12/28 13:38
 * @Version 1.0
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public ArrBinaryTree() {
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void midOrder() {
        midOrder(0);
    }

    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        if (2 * index + 1 < arr.length) {
            midOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    public void follOrder() {
        this.follOrder(0);
    }

    public void follOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println();
            return;
        }
        if (2 * index + 1 < arr.length) {
            follOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            follOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }

}
