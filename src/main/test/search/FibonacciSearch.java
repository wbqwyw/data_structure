package main.test.search;

import java.util.Arrays;

/**
 * @ClassName FibonacciSearch
 * @Description 斐波那契数列查找算法
 * @Author wbq
 * @Date 2020/12/27 20:32
 * @Version 1.0
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println("index=" + fibonacciSearch(arr, 1));
    }

    public static int fibonacciSearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int[] fip = fip(arr.length);
        while (right > fip[k] - 1) {
            k++;
        }
        if (right < fip[k] - 1) {
            arr = Arrays.copyOf(arr, fip[k] - 1);
            for (int i = right + 1; i < arr.length; i++) {
                arr[i] = arr[right];
            }
        }
        while (left <= right) {
            int mid = left + fip[k - 1] - 1;
            if (arr[mid] == value) {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
            if (arr[mid] > value) {
                right = mid - 1;
                //这个做k-1的操作原因是
                //此时证明value在mid左边的数组中，而这个数组又可分为f(k-1)-1 = (f(k-1-1)-1)(左边) + (f(k-2-1)-1)(右边)
                //相对于第一次的分割，只是将f数组的k角标前移一位
                k -= 1;
            }
            if (arr[mid] < value) {
                left = mid + 1;
                //这个做k-2的操作原因是
                //此时证明value在mid右边的数组中，而这个数组又可分为f(k-2)-1 = (f(k-2-1)-1)(左边) + (f(k-2-1)-1)(右边)
                //相对于第一次的分割，只是将f数组的k角标前移两位
                k -= 2;
            }
        }
        return -1;
    }

    public static int[] fip(int n) {
        if (n < 1) {
            return null;
        }
        int[] fip = new int[n];
        if (n >= 1) {
            fip[0] = 1;
        }
        if (n >= 2) {
            fip[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fip[i] = fip[i - 1] + fip[i - 2];
        }
        return fip;
    }


}
