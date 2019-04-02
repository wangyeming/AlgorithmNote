package chapter2;

import support.Partition;

/**
 * 三元组的数量
 * <p>
 * 给定一个数列a1,a2,a3,...,an和m个三元组表示的查询，对于每一个查询结果(i,j,k),输出ai,ai+1,...,aj的升序排列中的第k个数
 */
public class java_2_1_2 {

    public static void main(String[] argv) {
        int[] nums = {7, 9, 10, 5, 11, 1, 2, 15, 3, 4, 6, 13, 12, 8, 14};
        int[][] queryArray = {
                {2,6,3},
                {4,10,2},
                {1,7,4}
        };
        for(int[] query: queryArray){
            int i = query[0];
            int j = query[1];
            int k = query[2];
            System.out.print(" from " + i + " to " + j + " is [");
            for (int m = i; m <= j; m++) {
                System.out.print(nums[m] + ",");
            }
            System.out.print("]");
            System.out.println();
            System.out.println("min " + k + " is " + findMinK(nums, k, i, j));
            System.out.print(" from " + i + " to " + j + " is [");
            for (int m = i; m <= j; m++) {
                System.out.print(nums[m] + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }


    public static int findMinK(int[] nums, int k, int i, int j) {
        int n = nums.length;
        if (i < 0 || j > n - 1 || k > j - i || i > j) {
            return Integer.MIN_VALUE;
        }
        quickSelect(nums, k, i, j);
        return nums[i + k - 1];
    }

    public static void quickSelect(int[] nums, int k, int start, int end) {
        int index = Partition.partition1(nums, start, end);
        if (index > start && index > k + start - 1) {
            quickSelect(nums, k, start, index - 1);
        } else if (index < end && index < k + start - 1) {
            quickSelect(nums, k, index + 1, end);
        }
    }

}
