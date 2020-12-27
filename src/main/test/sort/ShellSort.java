package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName ShellSort
 * @Description 希尔排序-缩小增量排序
 * 希尔排序是为了解决如下插入排序的情况
 * 问题：
 * 当数组最后一位是最小值时，需要移动n-1位元素才能得到有序的数组
 * 例如：[1,2,3,4,5,0]
 * 此种情况比较费时
 * 思想：
 * 1.假想将数组进行多次分组，然后对每组进行插入排序
 * 举例：
 * int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
 * int gap = arr.length/2 = 5
 * 则arr[0]~arr[5] arr[1]~arr[6] ... 分别是一组
 * 插入排序完成之后，此时数组可能不是有序的，需要继续分组排序
 * =======================================================
 * 交换法：
 *  是只要元素小于前面的数，就要把前面所有的数都交换一次
 * 移位法：
 *  是只要元素小于前面的数，只是把元素后移，然后找到插入点，把元素插入到插入点
 *  而不需要每次都交换
 *
 * @Author wbq
 * @Date 2020/12/26 16:16
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        // 创建要给80000个的随机的数组
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shell2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static void shell(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shell2(int[] arr) {
        int j;
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && temp < arr[j]; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }

}
