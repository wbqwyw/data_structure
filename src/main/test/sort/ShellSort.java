package main.test.sort;

import java.util.Arrays;

/**
 * @program: data_structure
 * @description: 希尔排序-划分组，每一次继续细分，对每组进行冒泡
 * @author: Mr.Wang
 * @create: 2021-09-10 14:42
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        // int[] arr = new int[100];
        // for (int i = 0; i < 100; i++) {
        //     arr[i] = (int) (Math.random()*1000);
        // }
        sort2(arr);
    }

    /**
     * 希尔排序交换法
     */
    public static void sort(int[] arr) {
        int count = 0;
        int temp;
        for (int cap = arr.length / 2; cap > 0; cap /= 2) {
            for (int i = cap; i < arr.length; i++) {
                for (int j = i - cap; j >= 0; j -= cap) {
                    if (arr[j] > arr[j + cap]) {
                        temp = arr[j];
                        arr[j] = arr[j + cap];
                        arr[j + cap] = temp;
                    }
                }
            }
            System.out.println("循环次数：" + ++count + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序-移位法（其实还是交换，每组都是一次冒泡）
     */
    public static void sort2(int[] arr) {
        int count = 0;
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                //这一步和交换法的第三层循环一样的原理
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
            System.out.println("循环次数：" + ++count + Arrays.toString(arr));
        }
    }

}
