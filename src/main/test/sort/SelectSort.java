package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 选择排序-支持负数
 * 第一从arr[0]~arr[n-1]中选取最小值和arr[0]交换
 * 第二从arr[1]~arr[n-1]中选取最小值和arr[a]交换
 * 依次类推
 * O(n^2)
 * @author: Mr.Wang
 * @create: 2021-09-15 13:51
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        // int[] arr = new int[80];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = (int) (Math.random() * 8000);
        // }
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectSort(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
}
