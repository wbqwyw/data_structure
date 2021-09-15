package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 冒泡排序-支持负数
 * 假定最大值为末尾，则从arr[0]~arr[n-2]中获取最大值和假定最大值比较 交换
 * 下次从arr[0]~arr[n-3]中，依次往下循环
 * @author: Mr.Wang
 * @create: 2021-09-15 14:36
 **/
public class BubbleSort {
    public static void main(String[] args) {
        // int[] arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);//8000000 耗时 4678 4781 4806
        // bubbleSort2(arr);//8000000 耗时 13960 13154 12802
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // System.out.println(Arrays.toString(arr));
    }


    private static void bubbleSort(int[] arr) {
        int max = 0;
        int maxIndex = 0;

        int length = arr.length - 1;
        while (length >= 0) {
            max = arr[length];
            maxIndex = length;
            for (int i = 0; i < length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if (maxIndex != length) {
                arr[maxIndex] = arr[length];
                arr[length] = max;
            }
            length--;
        }
    }

    private static void bubbleSort2(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
