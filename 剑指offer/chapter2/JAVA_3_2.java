package chapter2;

/**
 * 不修改数组找出重复的数字
 * <p>
 * 数组长度为n+1，里面的元素值范围是1~n(必然至少有一个值重复了)
 */
public class JAVA_3_2 {

    public static void main(String[] argv) {
        int[] data1 = new int[]{2, 3, 5, 4, 4, 2, 6, 7};
        System.out.println(findOneRepeatNum(data1));

        int[] data2 = new int[]{2, 3, 5, 3, 4, 2, 6, 7};
        System.out.println(findOneRepeatNum(data2));

        int[] data3 = new int[]{};
        System.out.println(findOneRepeatNum(data3));
    }

    public static int findOneRepeatNum(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int start = 1;
        int end = numbers.length - 1;
        //确定[1,n]区间
        while (start <= end) {
            //将区间[1，n]二分，[1,m],[m,n]
            int middle = ((end - start) >> 1) + start;
            //统计[1,m]中1-m这些数出现的次数
            int count = countRange(numbers, start, middle);
            if (start == end) {
                //如果此时头尾指针相遇，也就是此时的区间只有一个元素
                if (count > 1) {
                    //说明start就是重复元素
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                //查找区间[1,m]
                end = middle;
            } else {
                //查找区间[m+1,n]
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int number : numbers) {
            if (number >= start && number <= end) {
                count++;
            }
        }
        return count;
    }
}
