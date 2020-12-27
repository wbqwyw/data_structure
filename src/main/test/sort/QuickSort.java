package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName QuickSort
 * @Description ��������
 * ˼�룺
 * 1.��һ���������߷ֽ���
 * 2.ͨ�����򣬽�����С�ڻ�����Ԫ�ض��ŵ���ߣ����ڻ�����Ԫ�ض��ŵ��ұ�
 * 3.Ȼ���ٶ���ߺ��ұߵ����������ٷֱ���п�������
 * 4.������ȥ�����������
 * @Author wbq
 * @Date 2020/12/26 21:11
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        quickSortTest(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ��������ֽ�����������ͷ
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
     * ��������ֽ����������鳤��һ���λ��
     */
    public static void quickSort4(int[] arr, int first, int rear) {
        //��ֹԽ��
        if (first < rear) {
            //��ֹl=r��������֣����³���ջ���
            int l = first - 1;
            int r = rear + 1;
            int privot = (first + rear) / 2;
            while (true) {
                //����ǰ�潫�Ǳ�����������⣬���Դ˴�Ҫ���ƶ�1λ����������
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
     * ��������ֽ�����������β
     */
    public static void quickSort3(int[] arr, int first, int rear) {

    }

    /**
     * ��������ֽ����������鳤��һ���λ��
     */
    private static void quickSort(int[] arr, int first, int rear) {
        int l = first;
        int r = rear;
        int priovt = (first + rear) / 2;
        //whileѭ����Ŀ�����ñ�pivot ֵС�ŵ����
        //��pivot ֵ��ŵ��ұ�
        while (l < r) {
            //��pivot�����һֱ��,�ҵ����ڵ���pivotֵ,���˳�
            while (arr[l] < arr[priovt]) {
                l++;
            }
            //��pivot���ұ�һֱ��,�ҵ�С�ڵ���pivotֵ,���˳�
            while (arr[r] > arr[priovt]) {
                r--;
            }
            swap(arr, l, r);
            //���l >= r˵��pivot ����������ֵ���Ѿ��������ȫ����
            //С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivotֵ
            if (r == l) {
                break;
            }
            //���������󣬷������arr[l] == pivotֵ ��� r--�� ǰ��
            if (arr[r] == arr[priovt]) {
                l++;
            }
            //���������󣬷������arr[r] == pivotֵ ��� l++�� ����
            if (arr[l] == arr[priovt]) {
                r--;
            }
        }
        // ��� l == r, ����l++, r--, ����Ϊ����ջ���
        if (l == r) {
            l++;
            r--;
        }
        //������ڵĻ�����߾�û�б�Ҫ����������
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
