package main.test.sparsearray;

import java.util.Arrays;

/**
 * @ClassName SparseArray
 * @Description ϡ������
 * @Author wbq
 * @Date 2020/12/21 22:18
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //����һ��ϡ������ 11 * 11
        // 0��ʾû�����ӣ�1������ӣ�2�������
        int[][] sparseArray = new int[11][11];
        sparseArray[1][2] = 1;
        sparseArray[2][3] = 2;
        //��¼��0���ֵĸ���
        //����д��
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        int sum = (int) Arrays.stream(sparseArray)
                .flatMapToInt((c) -> Arrays.stream(c).filter(a -> a > 0)).count();
        System.out.println(sum);
        //����ѹ����ϡ������
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = sparseArray.length;
        sparseArr[0][1] = sparseArray[0].length;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < sparseArray.length; i++) {
            for (int i1 = 0; i1 < sparseArray[i].length; i1++) {
                if (sparseArray[i][i1] > 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = i1;
                    sparseArr[count][2] = sparseArray[i][i1];
                }
            }
        }
        System.out.println("==========ѹ����ϡ������=========");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        System.out.println("=========��ѹ����ϡ�����黹ԭ��ϡ������=========");

        int[][] newSpareArray = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            newSpareArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] ints : newSpareArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
