package chapter2;

/**
 * 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里所有数字都在0~n-1的范围内。数组中某些数字是重复的，请找出任意一个重复的数字。
 * <p>
 * 考察点:一维数组的理解和编程能力
 */
public class JAVA_3_1 {
    public static void main(String[] argv) {
        System.out.println(findOneRepeatNumber(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 5}));
    }

    public static int findOneRepeatNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                continue;
            }
            if (array[i] == array[array[i]]) {
                return array[i];
            } else {
                swap(array, i, array[i]);
                i--;
            }
        }
        return -1;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
