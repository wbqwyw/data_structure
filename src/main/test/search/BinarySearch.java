package main.test.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data_structure
 * @description: 二分查找
 * @author: Mr.Wang
 * @create: 2021-09-15 16:42
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        // int index = binarySearch(arr, 0, arr.length - 1, 1000);
        // System.out.println("目标值索引：" + index);
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list.toString());
    }

    /**
     * 二分查找-把所有匹配的值都找出来
     */
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (target > midValue) {
            return binarySearch2(arr, mid + 1, right, target);
        } else if (target < midValue) {
            return binarySearch2(arr, left, mid - 1, target);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != target) {
                    break;
                }
                arrayList.add(temp);
                temp--;
            }
            temp = mid + 1;
            while (true) {
                if (temp < arr.length - 1 || arr[temp] != target) {
                    break;
                }
                arrayList.add(temp);
                temp++;
            }
            arrayList.add(mid);
            return arrayList;
        }

    }

    /**
     * 二分查找一个值
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (target > midValue) {
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < midValue) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }


}
