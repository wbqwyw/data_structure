package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 基数排序（桶排序-不支持负数）桶用二维数组第一维长度10，第二维长度即数组长度。
 * 先找出数组中最大的数，然后判断最大有几位数。
 * 先依据每个数的个位数放到对应的桶中，然后再依次取出放入原数组。其中使用一个一维数组，长度10，来存储每个桶存了多少个数。
 * 然后依次是十位，百位，依次循环。
 * @author: Mr.Wang
 * @create: 2021-09-15 09:33
 **/
public class RadixSort {

    public static void main(String[] args) {
        // int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 900);
        }
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int[][] r = new int[10][arr.length];
        int[] temp = new int[10];
        int max = arr[0];
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        maxLength = String.valueOf(max).length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int a = 0; a < arr.length; a++) {
                int index = arr[a] / n % 10;
                r[index][temp[index]] = arr[a];
                temp[index]++;
            }
            int index = 0;
            for (int j = 0; j < r.length; j++) {
                if (temp[j] != 0) {
                    for (int k = 0; k < temp[j]; k++) {
                        arr[index++] = r[j][k];
                        r[j][k] = 0;
                    }
                    temp[j] = 0;
                }
            }
        }

    }

}
