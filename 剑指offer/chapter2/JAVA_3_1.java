package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到数组中重复的数字
 * <p>
 * 长度为n的数组里所有数字都在0-n-1的范围内，某些数字是重复的，找到任意一个重复的数字
 * <p>
 * 考察点：一维数组的理解和编程能力
 */
public class JAVA_3_1 {

    public static void main(String[] argv) {
        int[] data1 = new int[]{1, 2, 3, 4, 5, 7, 8, 8, 9, 1, 2, 3, 4, 6, 6};
        int[] data2 = new int[]{1, 1};
        List<Integer> results1 = findAllRepeatNum(data1);
        List<Integer> results2 = findAllRepeatNum(data2);
        System.out.println(results1);
        System.out.println(results2);
    }

    //时间O(n)，空间O(1)
    public static List<Integer> findAllRepeatNum(int[] array) {
        List<Integer> repeatNumArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //从头到尾开始扫描这个数组
            if (array[i] == i) {
                continue;
            }
            //发现数值与下标不一致的数时,比较『下标=该数值的位置的数』和当前数
            while (true) {
                if (array[i] == i) {
                    break;
                }
                if (array[i] == array[array[i]]) {
                    //相等说明找到一个
                    repeatNumArray.add(array[i]);
                    break;
                } else {
                    //不相等，交换一下，停留原地继续比较
                    swap(array, i, array[i]);
                }

            }
        }
        return repeatNumArray;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
