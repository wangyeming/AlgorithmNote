package chapter2;

/**
 * 不修改数组找出重复的数字
 * <p>
 * 数组长度为n+1，里面的元素值范围是1~n(必然至少有一个值重复了),找出任意一个重复数字
 * 长度为n的数组里所有数字都在0-n-1的范围内，某些数字是重复的，找到任意一个重复的数字
 * <p>
 * 考察点：一维数组的理解和编程能力,二分法
 */
public class JAVA_3_2 {

    public static void main(String[] argv) {
        int[] data1 = new int[]{2, 3, 5, 4, 4, 2, 6, 7};
        System.out.println(findOneRepeatNum(data1));

        int[] data2 = new int[]{2, 3, 5, 3, 4, 2, 6, 7};
        System.out.println(findOneRepeatNum(data2));

        int[] data3 = new int[]{};
        System.out.println(findOneRepeatNum(data3));

        int[] data4 = new int[]{1, 2};
        System.out.println(findOneRepeatNum(data4));
    }

    //这题利用的二分法的思想，二分的对象是数字的范围1~n，千万别理解成二分数组了！！！！
    //时间复杂度O(nlogn)，空间O(1)
    //其中当然可以利用O(n)的辅助空间来实现O(n)的时间复杂度
    public static int findOneRepeatNum(int[] numbers) {
        if (numbers.length == 0) {
            //空数组的话，我们定义返回-1
            return -1;
        }
        //这里对应着题目：长度为n+1的数组，元素值范围是1~n
        int start = 1;                  //1
        int end = numbers.length - 1;   //n
        //确定[1,n]区间
        while (start <= end) {
            //将区间1-n二分，[1,m],[m+1,n]
            int middle = ((end - start) >> 1) + start;
            //统计数组中数值落在[1,m]中的个数
            int count = countRange(numbers, start, middle);
//            System.out.println("start " + start + " end " + end + " middle " + middle + " count " + count);

            //二分法的核心，要有跳出二分循环的时机
            if (start == end) {
                //如果此时头尾指针相遇，也就是此时的区间只有一个元素
                if (count > 1) {
                    //说明start就是重复元素
                    return start;
                } else {
                    //说明没有重复元素
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

    //统计数组中，值在[start, end]之间的数的个数
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
