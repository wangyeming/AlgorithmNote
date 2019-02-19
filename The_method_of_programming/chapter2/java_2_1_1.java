package chapter2;

import java.util.ArrayList;
import java.util.List;

//获取最大的k个数
public class java_2_1_1 {

    public static void main(String[] argv) {
        List<Integer> data = new ArrayList<>();
        data.add(10);
        data.add(2);
        data.add(56);
        data.add(12);
        data.add(89);
        data.add(3);
        data.add(4);
        data.add(77);
        System.out.println(data);
        List<Integer> results = getTopK(data, 3);
        System.out.println(results);
    }

    public static List<Integer> getTopK(List<Integer> nums, int k) {
        if (k >= nums.size()) {
            return nums;
        }
        quickSelect(nums, k, 0, nums.size() - 1);
        return nums.subList(0, k);

    }

    public static void quickSelect(List<Integer> nums, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = nums.get(right);
        while (i < j) {
            while (i < j && nums.get(i) >= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
            while (i < j && nums.get(j) <= pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        if (k <= i) {
            quickSelect(nums, k, left, i - 1);
        } else {
            quickSelect(nums, k, i, right);
        }

    }

    public static void swap(List<Integer> nums, int index1, int index2) {
        int tmp = nums.get(index1);
        nums.set(index1, nums.get(index2));
        nums.set(index2, tmp);
    }

    public static void print(Object str) {
        System.out.println(str.toString());

    }
}
