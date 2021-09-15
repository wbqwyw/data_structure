package main.test.queue;

import java.util.Scanner;

/**
 * @ClassName ArrayQueue
 * @Description ����1
 * @Author Administrator
 * @Date 2020/12/22 10:23
 * @Version 1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ����������ʼ���������");
        ArrayQueue arrayQueue = new ArrayQueue(scanner.nextInt());
        System.out.println("h:show");
        System.out.println("d:add");
        System.out.println("g:getOne");
        System.out.println("e:exit");
        boolean loop = true;
        while (loop) {
            String select = scanner.next();
            switch (select) {
                case ("h"):
                    arrayQueue.showQueue();
                    break;
                case ("d"):
                    System.out.println("������һ������");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case ("g"):
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }

    /**
     * ��������
     */
    int maxSize;
    /**
     * ����ͷ,��ʵ���Բ��ã������ȡ��Ԫ�ؼ�ɾ��������
     */
    int front;
    /**
     * ����β
     */
    int rear;
    /**
     * �洢���е�����
     */
    int[] arr;

    /**
     * ��ʼ������
     * ����ԭ��
     * 1.ȡ��Ԫ��ǰ����һ������ m ��¼��ǰ����ͷԪ��
     * 2.���彫Ԫ��ǰ��һλ����βԪ�ع�0����β��ʶrear��1
     * 3.����Ԫ�� m
     */
    public ArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            System.out.println("��ʼ�������������0");
            throw new RuntimeException("��ʼ�������������0����ǰ��ʼ������Ϊ��" + maxSize);
        }
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * �������
     */
    public void addQueue(int m) {
        if (isFull()) {
            System.out.println("�����������������Ԫ����~");
            return;
        }
        arr[++rear] = m;
    }

    /**
     * ��ȡ����ͷ�����ǲ�ɾ��
     */
    public int getFront() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ����ܻ�ȡͷ~");
            throw new RuntimeException("����Ϊ�գ����ܻ�ȡͷ~");
        }
        return arr[front];
    }

    /**
     * ��ȡ����β,���ǲ�ɾ��
     */
    public int getRear() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ����ܻ�ȡβ~");
            throw new RuntimeException("����Ϊ�գ����ܻ�ȡβ~");
        }
        return arr[rear];
    }

    /**
     * ȡ����Ȼ���0
     */
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ����ܻ�ȡ��~");
            throw new RuntimeException("����Ϊ�գ����ܻ�ȡ��~");
        }
        int result = arr[front + 1];
        if (rear > 1) {
            for (int i = 0; i <= rear - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        arr[rear] = 0;
        rear--;
        return result;
    }

    /**
     * �ж϶����Ƿ���
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * �ж϶����Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return front == rear;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ�û������~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

}
