package main.test.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTree
 * @Description 构造赫夫曼树
 * @Author Administrator
 * @Date 2020/12/29 9:26
 * @Version 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        HuffNode root = huffmanTree(arr);
        //测试一把
        preOrder(root);

    }

    public static void preOrder(HuffNode node) {
        if (node == null) {
            System.out.println("树为空");
            return;
        }
        System.out.println(node);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public static HuffNode huffmanTree(int[] arr) {
        if (arr == null || arr.length < 1) {
            System.out.println("数组为空");
            return null;
        }
        //将数组存入集合
        List<HuffNode> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new HuffNode(i));
        }
        //排序
        while (list.size() > 1) {
            Collections.sort(list);
            HuffNode left = list.get(0);
            HuffNode right = list.get(1);
            HuffNode parent = new HuffNode(left.value + right.value);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }
}

class HuffNode implements Comparable<HuffNode> {
    public int value;
    public HuffNode left;
    public HuffNode right;

    public HuffNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffNode o) {
        return this.value - o.value;
    }
}
