package main.test.queue;

import java.util.Scanner;

/**
 * @ClassName ArrayQueue
 * @Description 队列1
 * @Author Administrator
 * @Date 2020/12/22 10:23
 * @Version 1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数，初始化数组队列");
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
                    System.out.println("请输入一个整数");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case ("g"):
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
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
     * 队列容量
     */
    int maxSize;
    /**
     * 队列头,其实可以不用，如果是取出元素即删除的需求
     */
    int front;
    /**
     * 队列尾
     */
    int rear;
    /**
     * 存储队列的数组
     */
    int[] arr;

    /**
     * 初始化队列
     * 核心原理：
     * 1.取出元素前，用一个变量 m 记录当前队列头元素
     * 2.整体将元素前移一位，队尾元素归0，队尾标识rear减1
     * 3.返回元素 m
     */
    public ArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            System.out.println("初始化容量必须大于0");
            throw new RuntimeException("初始化容量必须大于0，当前初始化容量为：" + maxSize);
        }
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 添加数据
     */
    public void addQueue(int m) {
        if (isFull()) {
            System.out.println("队列已满，不能添加元素了~");
            return;
        }
        arr[++rear] = m;
    }

    /**
     * 获取队列头，但是不删除
     */
    public int getFront() {
        if (isEmpty()) {
            System.out.println("队列为空，不能获取头~");
            throw new RuntimeException("队列为空，不能获取头~");
        }
        return arr[front];
    }

    /**
     * 获取队列尾,但是不删除
     */
    public int getRear() {
        if (isEmpty()) {
            System.out.println("队列为空，不能获取尾~");
            throw new RuntimeException("队列为空，不能获取尾~");
        }
        return arr[rear];
    }

    /**
     * 取出，然后归0
     */
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能获取数~");
            throw new RuntimeException("队列为空，不能获取数~");
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
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

}
