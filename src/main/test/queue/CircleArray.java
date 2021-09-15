package main.test.queue;

import java.util.Scanner;

/**
 * @ClassName CircleArray
 * @Description ���ζ���
 * @Author Administrator
 * @Date 2020/12/22 17:31
 * @Version 1.0
 */
public class CircleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������һ����������ʼ���������");
        //���е���Ч����Ϊlength-1
        CircleArray circleArray = new CircleArray(scanner.nextInt());
        boolean loop = true;
        System.out.println("a:add");
        System.out.println("s:show");
        System.out.println("g:get");
        System.out.println("e:exit");
        while (true) {
            char input = scanner.next().charAt(0);
            switch (input) {
                case ('a'):
                    System.out.println("������һ������");
                    int number = scanner.nextInt();
                    circleArray.addQueue(number);
                    break;
                case ('s'):
                    circleArray.showQueue();
                    break;
                case ('g'):
                    circleArray.getQueue();
                    break;
                default:
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }

    private int maxsiz; // ��ʾ������������
    //front �����ĺ�����һ�������� front ��ָ����еĵ�һ��Ԫ��, Ҳ����˵ arr[front] ���Ƕ��еĵ�һ��Ԫ��
    //front �ĳ�ʼֵ = 0
    private int front;
    //rear �����ĺ�����һ��������rear ָ����е����һ��Ԫ�صĺ�һ��λ��. ��Ϊϣ���ճ�һ���ռ���ΪԼ��.
    //rear �ĳ�ʼֵ = 0
    private int rear; // ����β
    private int[] arr; // ���������ڴ������, ģ�����

    public CircleArray(int maxsiz) {
        this.maxsiz = maxsiz;
        arr = new int[maxsiz];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxsiz == front;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ��ȡ��ͷԪ�أ����ǲ�ɾ��
     * @Date 20:48 2020/12/22
     * @Param
     */
    public void getFront() {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
            return;
        }
        System.out.println(arr[front]);
        arr[front] = 0;
        front++;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ��ȡ��βԪ�أ����ǲ�ɾ��
     * @Date 20:48 2020/12/22
     * @Param
     */
    public void getRear() {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
        }
        System.out.println(arr[rear]);
        arr[rear] = 0;
        rear--;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ��ȡ���е���Ч����
     * @Date 21:04 2020/12/22
     * @Param
     */
    public int getAvalibleNumber() {
        return (rear - front + maxsiz) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ����������Ԫ��
     * @Date 21:05 2020/12/22
     * @Param
     */
    public void addQueue(int queue) {
        if (isFull()) {
            System.out.println("��������~");
            return;
        }
        arr[rear] = queue;
        //�� rear ����, ������뿼��ȡģ��ȡģ���ܹ��컷�ζ���
        rear = (rear + 1) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ȡ�����У�ȡ��β��0
     * @Date 22:25 2020/12/22
     * @Param
     */
    public void getQueue() {
        if (isEmpty()) {
            System.out.println("û������~");
        }
        int result = arr[front];
        //ȡ����0
        arr[front] = 0;
        System.out.println("ȡ�����ݣ�" + result);
        front = (front + 1) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description չʾ��ǰ���е���Ч����
     * @Date 22:26 2020/12/22
     * @Param
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("û������~");
            return;
        }
        for (int i = front; i < getAvalibleNumber() + front; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsiz, arr[i % maxsiz]);
        }
    }

}
