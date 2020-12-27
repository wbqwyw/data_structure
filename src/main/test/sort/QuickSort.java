package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * 思想：
 * 1.定一个基数或者分解数
 * 2.通过排序，将所有小于基数的元素都放到左边，大于基数的元素都放到右边
 * 3.然后再对左边和右边的两个数组再分别进行快速排序
 * 4.依次下去就完成了排序
 * @Author wbq
 * @Date 2020/12/26 21:11
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSortTest(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将基数或分解数定在数组头
     */
    public static void quickSort2(int[] arr, int first, int rear) {

    }

    public static void quickSortTest(int[] arr, int first, int rear) {
        if (first < rear) {
            int left = first - 1;
            int right = rear + 1;
            int privot = (first + rear) / 2;
            while (true) {
                while (arr[++left] < arr[privot]) ;
                while (arr[--right] > arr[privot]) ;
                if (left >= right) {
                    break;
                }
                swap(arr, left, right);
            }
            quickSortTest(arr, first, left - 1);
            quickSortTest(arr, right + 1, rear);
        }
    }

    /**
     * 将基数或分解数定在数组长度一半的位置
     */
    public static void quickSort4(int[] arr, int first, int rear) {
        //防止越界
        if (first < rear) {
            //防止l=r的情况出现，导致出现栈溢出
            int l = first - 1;
            int r = rear + 1;
            int privot = (first + rear) / 2;
            while (true) {
                //由于前面将角标放置在数组外，所以此处要先移动1位，进入数组
                while (arr[++l] < arr[privot]) ;
                while (arr[--r] > arr[privot]) ;
                if (l >= r) {
                    break;
                }
                swap(arr, l, r);
            }
            quickSort4(arr, first, l - 1);
            quickSort4(arr, r + 1, rear);
        }
    }

    /**
     * 将基数或分解数定在数组尾
     */
    public static void quickSort3(int[] arr, int first, int rear) {

    }

    /**
     * 将基数或分解数定在数组长度一半的位置
     */
    private static void quickSort(int[] arr, int first, int rear) {
        int l = first;
        int r = rear;
        int priovt = (first + rear) / 2;
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < arr[priovt]) {
                l++;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > arr[priovt]) {
                r--;
            }
            swap(arr, l, r);
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (r == l) {
                break;
            }
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[r] == arr[priovt]) {
                l++;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[l] == arr[priovt]) {
                r--;
            }
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //如果等于的话，左边就没有必要继续排序了
        if (first < r) {
            quickSort(arr, first, r);
        }
        if (rear > l) {
            quickSort(arr, l, rear);
        }

    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
