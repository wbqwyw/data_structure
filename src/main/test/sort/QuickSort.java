package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 快速排序-支持负数，先将小于标准值的数放在左边，大于的数放在右边，然后再对两边的数递归进行同样的操作。
 * @author: Mr.Wang
 * @create: 2021-09-13 14:53
 **/
public class QuickSort {

    public static void main(String[] args) {
        // int[] arr = new int[]{-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        int[] arr = new int[80];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int povit = arr[(left + right) / 2];
        int temp = 0;

        while (l < r) {
            while (arr[l] < povit) {
                l++;
            }
            while (arr[r] > povit) {
                r--;
            }
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, arr.length - 1);
        }

    }
}
