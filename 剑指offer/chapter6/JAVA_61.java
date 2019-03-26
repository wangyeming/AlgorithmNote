package chapter6;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * <p>
 * 从扑克牌种随机抽五张牌，判断是不是一个顺子。大小王可以堪称任意数字。
 * <p>
 * 考察点：抽象建模能力
 */
public class JAVA_61 {

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{5, 7, 0, 1, 2}));
        System.out.println(isContinuous(new int[]{5, 7, 0, 9, 0}));
        System.out.println(isContinuous(new int[]{5, 7, 0, 9, 6}));
    }

    //第一步排序
    //第二步计算0的个数
    //第三步计算gap数
    //0的个数>=gap数，就可以凑成顺子
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        for (int num : numbers) {
            if (num == 0) {
                zeroCount++;
            } else {
                break;
            }
        }
        int numberOfGap = 0;
        int slow = zeroCount;
        int fast = slow + 1;
        while (fast < numbers.length) {
            if (numbers[slow] == numbers[fast]) {
                //相同的牌，不可能成顺子
                return false;
            }
            numberOfGap += numbers[fast] - numbers[slow] - 1;
            slow = fast;
            fast++;
        }
        return zeroCount >= numberOfGap;
    }
}
