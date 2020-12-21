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

![image-20201221214517123](src\main\resource\image\image-20201221214517123.png)

> 举例

![image-20201221214639682](src\main\resource\image\image-20201221214639682.png)

![image-20201221215124602](src\main\resource\image\image-20201221215124602.png)

![image-20201221215752869](src\main\resource\image\image-20201221215752869.png)

![image-20201221215907737](src\main\resource\image\image-20201221215907737.png)
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
![image-20201221232828400](src\main\resource\image\image-20201221232828400.png)