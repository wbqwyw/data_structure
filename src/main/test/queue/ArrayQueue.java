package main.test.queue;

/**
 * @ClassName ArrayQueue
 * @Description 队列1
 * @Author Administrator
 * @Date 2020/12/22 10:23
 * @Version 1.0
 */
public class ArrayQueue {
    /**
     * 队列容量
     */
    int maxSize;
    /**
     * 队列头
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
            throw new RuntimeException("队列已满，不能添加元素了~");
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
     * 取数
     */
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，不能获取数~");
            throw new RuntimeException("队列为空，不能获取数~");
        }
        //取出头部元素后，将所有元素往前移动一位，相当于往前走一步，空出队尾
        if (arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        rear--;
        return arr[front + 1];
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
            throw new RuntimeException("队列为空，没有数据~");
        }
        for (int i : arr) {
            System.out.printf("%d\t\n", i);
        }
    }

}
