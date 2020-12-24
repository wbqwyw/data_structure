package main.test.linkedlist;

import java.util.Scanner;

/**
 * @ClassName Josefu
 * @Description 数组解决约瑟夫环的问题
 * 约瑟夫问题：设编号为1 2 3 ... n的个人坐一圈，约定编号为k的人开始从1报数，然后数到m的那个人
 * 出列，由下一个人继续开始从1报数，以此类推，直到所有人都出列。输出出列的编号
 * 思路:
 * 1.k是需要变的，和角标的关系是 角标=k-1
 * 2.m固定，不需要变
 * 3.取出的数做归0处理
 * 4.取出之后，往下一位时，要排除扫描到位0的元素
 * @Author Administrator
 * @Date 2020/12/24 16:47
 * @Version 1.0
 */
public class Josefu {
    public static void main(String[] args) {
        System.out.println("请输入一个整数，初始化队列");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("请输入一个整数，确定起始报数人");
        int k = scanner.nextInt();
        while (!(k >= 1 && k <= arr.length)) {
            System.out.println("输入的数超出队列长度，请重新输入一个1~" + arr.length + "的整数");
            k = scanner.nextInt();
        }
        System.out.println("请输入一个整数，确定出列间隔");
        int m = scanner.nextInt();
        //确定出列的人的下标
        int n = arr.length;
        while (n != 0) {
            //k-1因为数组下标为0
            //m-1因为k喊1，包含本身一步，故m-1。取模是为了做环形数组
            int k1 = (k - 1 + m - 1 + arr.length) % arr.length;
            //排除已经取出的元素
            while (arr[k1] == 0) {
                k1 = (++k) % arr.length;
            }
            System.out.println(arr[k1]);
            //取出归0
            arr[k1] = 0;
            //记录还有几个未取出
            --n;
            //取出之后，确定下一个k的位置，但是要排除已经取出的，如果没有可以取出的元素（n!=0），则结束
            while (arr[(k1 + 1) % arr.length] == 0 && n != 0) {
                k1++;
            }
            //重新定义报数位，因为k1是数组角标，需要+1，往下走一步，需要+1.故+2
            k = (k1 + 2) % arr.length;
        }
    }
}
