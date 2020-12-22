# `数据结构与算法`

### `线性结构和非线性结构`

> *线性结构*:
>
> - 元素之间存在一对一的关系，例如：a[0]=1
> - 有两种不同的存储结构，及顺序存储结构和链式存储结构。顺序存储的线性表称为顺序表，顺序表中存储的元素是连续的。
> - 链式存储的线性表称为链表，链表中的元素不一定是连续的，元素节点中存放元素本身以及相邻元素的地址信息
> - 线性结构常见的有：数组、队列、链表、栈
>
> *非线性结构*:
>
> - 非线性结构包括：二位数组、多维数组、广义表、树结构、图结构	  

### `稀疏数组和队列`

> **`介绍`**:当一个数组中的元素大部分为0，或者为同一个值的数组时，可以使用稀疏数组保存该数组。

> 稀疏数组的处理方式：
>
> - 记录数组中有几行几列，有多少个不同的值。
> - 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模。

![image-20201221214517123](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221214517123.png)

> 举例

![image-20201221214639682](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221214639682.png)

![image-20201221215124602](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221215124602.png)

![image-20201221215752869](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221215752869.png)

![image-20201221215907737](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221215907737.png)
```java
package main.test.sparsearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName SparseArray
 * @Description 稀疏数组
 * @Author wbq
 * @Date 2020/12/21 22:18
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个稀疏数组 11 * 11
        // 0表示没有棋子，1代表白子，2代表黑子
        int[][] sparseArray = new int[11][11];
        sparseArray[1][2] = 1;
        sparseArray[2][3] = 2;
        //记录非0数字的个数
        //常规写法
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        int sum = (int) Arrays.stream(sparseArray)
                .flatMapToInt((c) -> Arrays.stream(c).filter(a -> a > 0)).count();
        System.out.println(sum);
        //创建压缩的稀疏数组
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
        System.out.println("==========压缩的稀疏数组=========");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        System.out.println("=========将压缩的稀疏数组还原成稀疏数组=========");

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

```
![image-20201221232828400](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201221232828400.png)

##### 队列

> `介绍`
>
> - 队列是一个有序列表，可以用数组或链表实现
>
> - 遵循**先入先出**原则。即先存入的数据先取出。
>
> - 示例
>
>   ![image-20201222100120681](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222100120681.png)

![image-20201222100651456](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222100651456.png)

![image-20201222100953446](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222100953446.png)

```java
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
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
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
```

> - 上述方式的队列为一次性队列，因为头部取出之后，头部取出的数据的位置不能再被放进值
>
> - 优化为环形队列
>
>   ![image-20201222113005175](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222113005175.png)
##### 链表

> `介绍`
>
> - 链表是一个有序列表，它的内存存储如下：

![image-20201222230516166](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222230516166.png)

![image-20201222232432311](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201222232432311.png)
