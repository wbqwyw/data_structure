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

**链表示例**
```java
package main.test.linkedlist;

import java.net.HttpRetryException;
import java.util.Stack;

/**
 * @ClassName SingleOrderLinkedList
 * @Description 有序链表--和添加元素顺序没有关系，按照heroNode 的 no排序,以及反转链表
 * @Author Administrator
 * @Date 2020/12/23 16:02
 * @Version 1.0
 */
public class SingleOrderLinkedList {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(5, "李逵", "黑旋风");
        HeroNode hero6 = new HeroNode(6, "鲁智深", "花和尚");
        HeroNode hero7 = new HeroNode(7, "杨志", "青面兽");
        //创建要给链表
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero6);
        singleLinkedList.add(hero7);
        SingleOrderLinkedList singleLinkedList2 = new SingleOrderLinkedList();
        singleLinkedList2.add(hero5);
        singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.show();
        singleLinkedList.merge(singleLinkedList2);
        System.out.println("合并一个链表之后~~");
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
//        singleLinkedList = singleLinkedList.reverse(singleLinkedList);
//        singleLinkedList.reverse2(singleLinkedList);
        System.out.println("=============reversePrint=============");
        singleLinkedList.reversePrint(singleLinkedList.head);
        singleLinkedList.reverse3();
        System.out.println("=============reverse=============");
        singleLinkedList.show();
        System.out.println("=============update=============");
        HeroNode hero100 = new HeroNode(2, "卢俊义", "玉麒麟~");
        singleLinkedList.update(hero100);
        singleLinkedList.show();
        System.out.println("=============findLast=============");
        singleLinkedList.findLast(3);
        System.out.println("=============delete=============");
//        HeroNode hero6 = new HeroNode(2, "卢俊义", "玉麒麟~");
//        singleLinkedList.delete(hero6);
        singleLinkedList.delete2(2);
        singleLinkedList.show();
    }

    private HeroNode head = new HeroNode(0, null, null);

    public boolean isEmpty() {
        return head.next == null;
    }

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void add2(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("当前没有数据");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 查找倒数第index个节点
     * @Date 11:07 2020/12/24
     * @Param
     */
    public void findLast(int index) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        int size = size();
        if (index <= 0 || index > size) {
            System.out.println("该节点不在链表范围内");
            return;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        System.out.println(temp.toString());
    }

    /**
     * @return
     * @Author wangbq
     * @Description //链表反转，此方法的原理，新建一个链表（初始化一个head），
     * 然后依次取出最后一个node,放到新的head后，后续依次插入head.next
     * 1.计算原链表长度m
     * 2.指针temp指向head
     * 3.变量n
     * 4.让指针往尾部走，走m步长，n++记录步长，当n=m时，及代表走到队尾。取出
     * 元素，然后m--。temp=sl.head  n=0 初始化归为，从新遍历
     * 5.当m=0时，表示有效元素全部取出
     * @Date 9:43 2020/12/24
     * @Param
     */
    public SingleOrderLinkedList reverse(SingleOrderLinkedList sl) {
        if (sl.isEmpty()) {
            System.out.println("链表为空");
            return sl;
        }
        SingleOrderLinkedList newList = new SingleOrderLinkedList();
        //去除head
        int m = sl.size();
        HeroNode temp = sl.head;
        int n = 0;
        while (!(m == 0)) {
            if (n == m) {
                temp.next = null;
                newList.add2(temp);
                temp = sl.head;
                m--;
                n = 0;
            }
            n++;
            temp = temp.next;
        }
        sl = newList;
        return sl;
    }

    public void reverse3() {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode newHead = new HeroNode(0, null, null);
        int m = size();
        int n = 0;
        HeroNode temp = head;
        while (!(m == n)) {
            n++;
            temp = temp.next;
            HeroNode node = new HeroNode(temp.no, temp.name, temp.minName);
            HeroNode next = newHead.next;
            node.next = next;
            newHead.next = node;
        }
        head.next = newHead.next;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 链表反转方式2
     * 原理：先初始化一个head，然后依次从前到后取出元素，连接到head后面，新元素要插入head和next之间。保证反转
     * 然后，将原head.next = newHead.next
     * 1.HeroNode newHead = new HeroNode(0,null,null);
     * 2.HeroNode temp = sl.head.next;
     * 3. while(true){
     * if(temp.next==null){
     * break;
     * }
     * temp.next=newHead.next;
     * newHead.next = temp;
     * }
     * sl.head.next = newHead.next;
     * @Date 9:52 2020/12/24
     * @Param
     */
    public void reverse2(SingleOrderLinkedList sl) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode newHead = new HeroNode(0, null, null);
        HeroNode temp = sl.head.next;
        while (temp == null) {
            HeroNode node = new HeroNode(temp.no, temp.name, temp.minName);
            HeroNode next = newHead.next;
            newHead.next = node;
            node.next = next;
            temp = temp.next;
        }
        sl.head.next = newHead.next;
    }

    /**
     * @return
     * @Author wangbq
     * @Description 反转打印，不改变原链表结构
     * @Date 15:14 2020/12/24
     * @Param
     */
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空，不能打印");
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (!heroNodes.empty()) {
            System.out.println(heroNodes.pop());
        }
    }

    public void update(HeroNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.minName = node.minName;
            }
            temp = temp.next;
        }
    }

    /**
     * 链表合并
     */
    public void merge(SingleOrderLinkedList a) {
        if (a.isEmpty()) {
            System.out.println("要添加的链表为空");
        }
        HeroNode temp = a.head.next;
        while (temp != null) {
            this.add(new HeroNode(temp.no, temp.name, temp.minName));
            temp = temp.next;
        }
    }

    public void delete(HeroNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        HeroNode temp_pre = head;
        while (temp != null) {
            if (temp.no == node.no) {
                temp_pre.next = temp.next;
                break;
            }
            temp_pre = temp_pre.next;
            temp = temp.next;
        }
    }

    public void delete2(int no) {
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有改节点");
        }
    }

}
```
##### 双向链表

###### **图解**

![image-20201224160045882](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201224160045882.png)

#### 约瑟夫问题

![image-20201224162936911](https://github.com/wbqwyw/data_structure/blob/master/src/main/resource/image/image-20201224162936911.png)

> 使用循环数组的方式解决

```java
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
```

