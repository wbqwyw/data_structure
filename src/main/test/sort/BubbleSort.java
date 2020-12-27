package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName BubbleSort
 * @Description ð������
 * ˼·��
 * 1.�����Ԫ������ƶ�
 * 2.�õ�1��Ԫ�غ͵�2���Ƚϣ��͵�3���Ƚϣ��͵�4���Ƚ�...
 * @Author wbq
 * @Date 2020/12/26 15:32
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        // ����Ҫ��80000�������������
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//		}

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        bubble2(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

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
        //arr.length - 1 ��ԭ������Ϊ��i Ҫ����һ��Ԫ�رȽϣ���һ��Ԫ��Ϊ i+1
        //�����Ĵ���
        for (int i = 0; i < arr.length - 1; i++) {
            //��0��ʼ������ÿ����һ�Σ����һλ�������ֵ
            //Ȼ���1���������������Ѿ�ȷ�����һλ�����ֵ������û�б�Ҫ�ٱ������һλ������󳤶ȼ�1λ
            //arr.length -1 ��ԭ���� j �� j + 1 ���Ƚ�
            //��flag��ʶ��ԭ�򣬱�ʾ����һ��֮��û����Ҫ������Ԫ�ء����Ѿ���ʾ������������ˡ�
            //��ʱ�Ͳ���Ҫ�ٱ������˷�ʱ����
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
