# `���ݽṹ���㷨`

### `���Խṹ�ͷ����Խṹ`

> *���Խṹ*:
>
> - Ԫ��֮�����һ��һ�Ĺ�ϵ�����磺a[0]=1
> - �����ֲ�ͬ�Ĵ洢�ṹ����˳��洢�ṹ����ʽ�洢�ṹ��˳��洢�����Ա��Ϊ˳���˳����д洢��Ԫ���������ġ�
> - ��ʽ�洢�����Ա��Ϊ���������е�Ԫ�ز�һ���������ģ�Ԫ�ؽڵ��д��Ԫ�ر����Լ�����Ԫ�صĵ�ַ��Ϣ
> - ���Խṹ�������У����顢���С�����ջ
>
> *�����Խṹ*:
>
> - �����Խṹ��������λ���顢��ά���顢��������ṹ��ͼ�ṹ	  

### `ϡ������Ͷ���`

> **`����`**:��һ�������е�Ԫ�ش󲿷�Ϊ0������Ϊͬһ��ֵ������ʱ������ʹ��ϡ�����鱣������顣

> ϡ������Ĵ���ʽ��
>
> - ��¼�������м��м��У��ж��ٸ���ͬ��ֵ��
> - �Ѿ��в�ֵͬ��Ԫ�ص����м�ֵ��¼��һ��С��ģ�������У��Ӷ���С����Ĺ�ģ��

![image-20201221214517123](src\main\resource\image\image-20201221214517123.png)

> ����

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
 * @Description ϡ������
 * @Author wbq
 * @Date 2020/12/21 22:18
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //����һ��ϡ������ 11 * 11
        // 0��ʾû�����ӣ�1������ӣ�2�������
        int[][] sparseArray = new int[11][11];
        sparseArray[1][2] = 1;
        sparseArray[2][3] = 2;
        //��¼��0���ֵĸ���
        //����д��
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        int sum = (int) Arrays.stream(sparseArray)
                .flatMapToInt((c) -> Arrays.stream(c).filter(a -> a > 0)).count();
        System.out.println(sum);
        //����ѹ����ϡ������
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
        System.out.println("==========ѹ����ϡ������=========");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        System.out.println("=========��ѹ����ϡ�����黹ԭ��ϡ������=========");

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