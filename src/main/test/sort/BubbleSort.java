package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * 思路：
 * 1.将大的元素向后移动
 * 2.拿第1个元素和第2个比较，和第3个比较，和第4个比较...
 * @Author wbq
 * @Date 2020/12/26 15:32
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        // 创建要给80000个的随机的数组
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        bubble2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void bubble2(int[] arr) {
        boolean flag = false;
        //arr.length - 1 的原因是因为，i 要和下一个元素比较，下一个元素为 i+1
        //遍历的次数
        for (int i = 0; i < arr.length - 1; i++) {
            //从0开始遍历，每遍历一次，最后一位就是最大值
            //然后从1继续遍历，但是已经确定最后一位是最大值，所以没有必要再遍历最后一位，故最大长度减1位
            //arr.length -1 的原因是 j 和 j + 1 作比较
            //做flag标识的原因，表示遍历一遍之后，没有需要交换的元素。就已经表示数组是有序的了。
            //此时就不需要再遍历，浪费时间了
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
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
