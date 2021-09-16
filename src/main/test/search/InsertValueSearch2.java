package main.test.search;


/**
 * @program: data_structure
 * @description: 插值查找
 * @author: Mr.Wang
 * @create: 2021-09-16 15:52
 **/
public class InsertValueSearch2 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        // int index = insertValueSearch(arr, 89);

        int index = insertValueSearch2(arr, 0, arr.length - 1, 89);

        System.out.println("索引：" + index);

    }

    private static int insertValueSearch2(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[left] || target > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        if (target > arr[mid]) {
            return insertValueSearch2(arr, mid + 1, right, target);
        } else if (target < arr[mid]) {
            return insertValueSearch2(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }

    private static int insertValueSearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
            if (mid >= left && mid < right) {
                if (target > arr[mid]) {
                    left = mid + 1;
                } else if (target < arr[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                break;
            }
        }
        return -1;
    }
}
