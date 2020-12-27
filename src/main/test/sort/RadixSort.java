package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName RadixSort
 * @Description ��������
 * @Author wbq
 * @Date 2020/12/27 12:37
 * @Version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};

        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//        }
        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

        System.out.println("���������=" + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr.length < 1) {
            System.out.println("���鲻��Ϊ��");
            return;
        }
        int max = arr[0];
        int[][] bucktArr = new int[10][arr.length];
        int[] temp = new int[10];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //����
            for (int j = 0; j < arr.length; j++) {
                int position = (arr[j] / n) % 10;
                bucktArr[position][temp[position]] = arr[j];
                temp[position]++;
            }
            //ȡ��
            int index = 0;
            for (int k = 0; k < bucktArr.length; k++) {
                for (int j = 0; j < temp[k]; j++) {
                    arr[index] = bucktArr[k][j];
                    index++;
                }
                temp[k] = 0;
            }
        }
    }
}
