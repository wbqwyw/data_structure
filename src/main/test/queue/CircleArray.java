package main.test.queue;

import java.util.Scanner;

/**
 * @ClassName CircleArray
 * @Description 环形队列
 * @Author Administrator
 * @Date 2020/12/22 17:31
 * @Version 1.0
 */
public class CircleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数，初始化数组队列");
        //队列的有效长度为length-1
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
                    System.out.println("请输入一个整数");
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

    private int maxsiz; // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

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
     * @Description 获取队头元素，但是不删除
     * @Date 20:48 2020/12/22
     * @Param
     */
    public void getFront() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.println(arr[front]);
        arr[front] = 0;
        front++;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 获取队尾元素，但是不删除
     * @Date 20:48 2020/12/22
     * @Param
     */
    public void getRear() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        System.out.println(arr[rear]);
        arr[rear] = 0;
        rear--;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 获取队列的有效长度
     * @Date 21:04 2020/12/22
     * @Param
     */
    public int getAvalibleNumber() {
        return (rear - front + maxsiz) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 向队列中添加元素
     * @Date 21:05 2020/12/22
     * @Param
     */
    public void addQueue(int queue) {
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        arr[rear] = queue;
        //将 rear 后移, 这里必须考虑取模，取模才能构造环形队列
        rear = (rear + 1) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 取出队列，取出尾归0
     * @Date 22:25 2020/12/22
     * @Param
     */
    public void getQueue() {
        if (isEmpty()) {
            System.out.println("没有数据~");
        }
        int result = arr[front];
        //取出归0
        arr[front] = 0;
        System.out.println("取出数据：" + result);
        front = (front + 1) % maxsiz;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 展示当前队列的有效数据
     * @Date 22:26 2020/12/22
     * @Param
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("没有数据~");
            return;
        }
        for (int i = front; i < getAvalibleNumber() + front; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsiz, arr[i % maxsiz]);
        }
    }

}
