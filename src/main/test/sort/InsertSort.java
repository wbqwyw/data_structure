package main.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName InsertSort
 * @Description //��������-��С����
 * ˼�룺
 * 1.���뽫�����Ϊ����������������飬���Ϊ�����ұ�Ϊ����
 * 2.���������һ��Ԫ��Ϊ���������һ��Ԫ�أ�����������ӵڶ���Ԫ�ؿ�ʼ����
 * 3.����������Ԫ�غ���������Ƚϣ������������Ԫ��С����������Ԫ�أ�����λ�á�
 * ��������Ԫ�رȽ���������Ԫ�أ�����������ĩβԪ�ؿ�ʼ���αȽϣ�ֻҪ��������
 * Ԫ�ش�����������Ԫ�أ�����������Ԫ��ǰ�ơ�ֱ������һ��С������Ԫ��
 * ����˼�룺
 * ���飬������ǰ����
 * ���⣺
 * ���������һλ����Сֵʱ����Ҫ�ƶ�n-1λԪ�ز��ܵõ����������
 * ���磺[1,2,3,4,5,0]
 * ��������ȽϷ�ʱ
 * @Author wbq
 * @Date 2020/12/26 14:58
 * @Version 1.0
 */
public class InsertSort {
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

        insert(arr);//��λ��ʽ

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                //������Ԫ��������
                arr[j + 1] = arr[j];
            }
            //j+1��ԭ����ǵ��˳�ѭ��֮��j = -1
            arr[j + 1] = temp;
        }
    }
}
