package main.test.search;

/**
 * @ClassName InsertValueSearch
 * @Description 插值查找
 * 相对二分查找优化而已，优化的是mid值的选定
 * @Author wbq
 * @Date 2020/12/27 21:20
 * @Version 1.0
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println("index=" + insertValueSearch2(arr, 0, arr.length - 1, 89));
    }

    /**
     * 非迭代方式
     */
    public static int insertValueSearch(int[] arr, int value) {
        if (arr.length < 1) {
            System.out.println("数组为空");
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]);
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                left = mid + 1;
            }
            if (arr[mid] > value) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 迭代的方式
     */
    public static int insertValueSearch2(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[left] || value > arr[right]) {
            System.out.println("没有该数据");
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] > value) {
            return insertValueSearch2(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return insertValueSearch2(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
