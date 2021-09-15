package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 归并排序-支持负数，典型的分治思想。二分之后，对每组进行二分，分到每组只有两个的时候，比较大小，然后合并。
 * 将小的数据先放入同样长度的空数组中，这样备份数组是有序的，然后再取出备份数组的值，放到原数组。
 * @author: Mr.Wang
 * @create: 2021-09-14 16:26
 **/
public class MergeSort {

    public static void main(String[] args) {
        // int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 900);
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
