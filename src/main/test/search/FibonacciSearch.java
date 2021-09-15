package main.test.search;

import java.util.Arrays;

/**
 * @ClassName FibonacciSearch
 * @Description 쳲��������в����㷨
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
                //�����k-1�Ĳ���ԭ����
                //��ʱ֤��value��mid��ߵ������У�����������ֿɷ�Ϊf(k-1)-1 = (f(k-1-1)-1)(���) + (f(k-2-1)-1)(�ұ�)
                //����ڵ�һ�εķָֻ�ǽ�f�����k�Ǳ�ǰ��һλ
                k -= 1;
            }
            if (arr[mid] < value) {
                left = mid + 1;
                //�����k-2�Ĳ���ԭ����
                //��ʱ֤��value��mid�ұߵ������У�����������ֿɷ�Ϊf(k-2)-1 = (f(k-2-1)-1)(���) + (f(k-2-1)-1)(�ұ�)
                //����ڵ�һ�εķָֻ�ǽ�f�����k�Ǳ�ǰ����λ
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
