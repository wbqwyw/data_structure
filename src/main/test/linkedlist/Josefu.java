package main.test.linkedlist;

import java.util.Scanner;

/**
 * @ClassName Josefu
 * @Description ������Լɪ�򻷵�����
 * Լɪ�����⣺����Ϊ1 2 3 ... n�ĸ�����һȦ��Լ�����Ϊk���˿�ʼ��1������Ȼ������m���Ǹ���
 * ���У�����һ���˼�����ʼ��1�������Դ����ƣ�ֱ�������˶����С�������еı��
 * ˼·:
 * 1.k����Ҫ��ģ��ͽǱ�Ĺ�ϵ�� �Ǳ�=k-1
 * 2.m�̶�������Ҫ��
 * 3.ȡ����������0����
 * 4.ȡ��֮������һλʱ��Ҫ�ų�ɨ�赽λ0��Ԫ��
 * @Author Administrator
 * @Date 2020/12/24 16:47
 * @Version 1.0
 */
public class Josefu {
    public static void main(String[] args) {
        System.out.println("������һ����������ʼ������");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("������һ��������ȷ����ʼ������");
        int k = scanner.nextInt();
        while (!(k >= 1 && k <= arr.length)) {
            System.out.println("��������������г��ȣ�����������һ��1~" + arr.length + "������");
            k = scanner.nextInt();
        }
        System.out.println("������һ��������ȷ�����м��");
        int m = scanner.nextInt();
        //ȷ�����е��˵��±�
        int n = arr.length;
        while (n != 0) {
            //k-1��Ϊ�����±�Ϊ0
            //m-1��Ϊk��1����������һ������m-1��ȡģ��Ϊ������������
            int k1 = (k - 1 + m - 1 + arr.length) % arr.length;
            //�ų��Ѿ�ȡ����Ԫ��
            while (arr[k1] == 0) {
                k1 = (++k) % arr.length;
            }
            System.out.println(arr[k1]);
            //ȡ����0
            arr[k1] = 0;
            //��¼���м���δȡ��
            --n;
            //ȡ��֮��ȷ����һ��k��λ�ã�����Ҫ�ų��Ѿ�ȡ���ģ����û�п���ȡ����Ԫ�أ�n!=0���������
            while (arr[(k1 + 1) % arr.length] == 0 && n != 0) {
                k1++;
            }
            //���¶��屨��λ����Ϊk1������Ǳ꣬��Ҫ+1��������һ������Ҫ+1.��+2
            k = (k1 + 2) % arr.length;
        }
    }
}
