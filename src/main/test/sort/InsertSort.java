package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 插入排序-支持负数
 * 将数组分为有序（第一位）和无序（1~arr.length-1）
 * 每次拿无序的第一位和有序的数组做比较，找到合适的位置进行插入
 * @author: Mr.Wang
 * @create: 2021-09-15 10:42
 **/
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        // int[] arr = new int[80];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = (int) (Math.random() * 8000);
        // }
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        int temp = 0;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            index = i - 1;
            temp = arr[i];
            while (index >= 0 && temp <= arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            if (index + 1 != i) {
                arr[index + 1] = temp;
            }
            System.out.println("循环排序：" + Arrays.toString(arr));
        }
    }
}
