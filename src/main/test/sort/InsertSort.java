package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName InsertSort
 * @Description //插入排序-从小到大
 * 思想：
 * 1.假想将数组分为有序和无序两个数组，左边为有序，右边为无序
 * 2.有序数组第一个元素为无序数组第一个元素，无序数组则从第二个元素开始遍历
 * 3.拿无序数组元素和有序数组比较，如果无序数组元素小于有序数组元素，交换位置。
 * 无序数组元素比较有序数组元素，从有序数组末尾元素开始依次比较，只要有序数组
 * 元素大于无序数组元素，则将无序数组元素前移。直至遇到一个小于它的元素
 * 主体思想：
 * 分组，依次往前遍历
 * 问题：
 * 当数组最后一位是最小值时，需要移动n-1位元素才能得到有序的数组
 * 例如：[1,2,3,4,5,0]
 * 此种情况比较费时
 * @Author wbq
 * @Date 2020/12/26 14:58
 * @Version 1.0
 */
public class InsertSort {
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

        insert(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                //将有序元素往后拿
                arr[j + 1] = arr[j];
            }
            //j+1的原因就是当退出循环之后，j = -1
            arr[j + 1] = temp;
        }
    }
}
