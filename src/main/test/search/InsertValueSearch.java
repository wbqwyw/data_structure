package main.test.search;

/**
 * @program: data_structure
 * @description: 插值查找
 * @author: Mr.Wang
 * @create: 2021-09-16 15:52
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        long start = System.currentTimeMillis();
        int index = insertValueSearch(arr, 236);//8000000 ��ʱ 4678 4781 4806
        // int index = insertValueSearch2(arr, 0, arr.length - 1, 89);//8000000 ��ʱ 13960 13154 12802
        long end = System.currentTimeMillis();
        System.out.println("索引：" + index + " 耗时：" + (end - start));
        // System.out.println("index=" + insertValueSearch2(arr, 0, arr.length - 1, 89));
    }

    /**
     * 非迭代
     */
    public static int insertValueSearch(int[] arr, int value) {
        if (arr.length < 1) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]);
            //防止数组越界
            if (mid >= left && mid <= right) {
                if (arr[mid] < value) {
                    left = mid + 1;
                } else if (arr[mid] > value) {
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

    /**
     * 迭代
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
