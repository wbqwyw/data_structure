package main.test.queue;

/**
 * @ClassName ArrayQueue
 * @Description ����1
 * @Author Administrator
 * @Date 2020/12/22 10:23
 * @Version 1.0
 */
public class ArrayQueue {
    /**
     * ��������
     */
    int maxSize;
    /**
     * ����ͷ
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
            throw new RuntimeException("�����������������Ԫ����~");
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
     * ȡ��
     */
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ����ܻ�ȡ��~");
            throw new RuntimeException("����Ϊ�գ����ܻ�ȡ��~");
        }
        //ȡ��ͷ��Ԫ�غ󣬽�����Ԫ����ǰ�ƶ�һλ���൱����ǰ��һ�����ճ���β
        if (arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        rear--;
        return arr[front + 1];
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
            throw new RuntimeException("����Ϊ�գ�û������~");
        }
        for (int i : arr) {
            System.out.printf("%d\t\n", i);
        }
    }

}
