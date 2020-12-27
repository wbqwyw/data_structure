package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName ShellSort
 * @Description ϣ������-��С��������
 * ϣ��������Ϊ�˽�����²�����������
 * ���⣺
 * ���������һλ����Сֵʱ����Ҫ�ƶ�n-1λԪ�ز��ܵõ����������
 * ���磺[1,2,3,4,5,0]
 * ��������ȽϷ�ʱ
 * ˼�룺
 * 1.���뽫������ж�η��飬Ȼ���ÿ����в�������
 * ������
 * int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
 * int gap = arr.length/2 = 5
 * ��arr[0]~arr[5] arr[1]~arr[6] ... �ֱ���һ��
 * �����������֮�󣬴�ʱ������ܲ�������ģ���Ҫ������������
 * =======================================================
 * ��������
 *  ��ֻҪԪ��С��ǰ���������Ҫ��ǰ�����е���������һ��
 * ��λ����
 *  ��ֻҪԪ��С��ǰ�������ֻ�ǰ�Ԫ�غ��ƣ�Ȼ���ҵ�����㣬��Ԫ�ز��뵽�����
 *  ������Ҫÿ�ζ�����
 *
 * @Author wbq
 * @Date 2020/12/26 16:16
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        // ����Ҫ��80000�������������
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        shell2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

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
