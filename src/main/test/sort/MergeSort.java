package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName MergeSort
 * @Description //�鲢����
 * @Author wbq
 * @Date 2020/12/26 23:32
 * @Version 1.0
 */
public class MergeSort {
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

        int temp[] = new int[arr.length]; //�鲢������Ҫһ������ռ�
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

        System.out.println("�鲢�����=" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //����ֽ�
            mergeSort(arr, left, mid, temp);
            //���ҷֽ�
            mergeSort(arr, mid + 1, right, temp);
            //�ϲ�
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * �ϲ�
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            //�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
            //������ߵĵ�ǰԪ�أ���䵽 temp����
            //Ȼ�� t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //��֮,���ұ��������еĵ�ǰԪ�أ���䵽temp����
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //������ʣ�࣬��ֱ�����η���������
        while (i <= mid) { //��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //�ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left; //
        //��һ�κϲ� tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //���һ�� tempLeft = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }


}
