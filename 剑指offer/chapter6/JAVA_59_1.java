package chapter6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * <p>
 * 考察点：滑动窗口
 */
public class JAVA_59_1 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int[] maxInWindow = maxInWindow(array, 3);
        System.out.println(Arrays.toString(maxInWindow));
        int[] minInWindow = minInWindow(array, 3);
        System.out.println(Arrays.toString(minInWindow));
    }

    //直观的思路是，对数组每个元素，都计算一下size=k的窗口中的最大值,那么时间复杂度是O(kn)
    //如果借助滑动窗口的思路，可以把时间复杂度降为O(n)
    //思路是，维护一个size=k的双端队列(目的是方便从队列头和对列位，添加和删除元素)
    //假设数组为[2, 3, 4, 2, 6, 2, 5, 1], k=3
    //那么整个计算过程为：
    //step  insert_num  window      queue_index         max
    //1         2       [2]         0(2)                -
    //2         3       [2,3]       1(3)                -
    //3         4       [2,3,4]     2(4)                4
    //4         2       [3,4,2]     2(4),3(2)           4
    //5         6       [4,2,6]     4(6)                6
    //6         2       [2,6,2]     4(6),5(2)           6
    //7         5       [6,2,5]     4(6),6(5)           6
    //8         1       [2,5,1]     6(5),7(1)           5
    //可以看到，队列的维护规则是，
    //1. 如果队列为空，直接添加。
    //2. 添加元素前，先判断队列首位的index和准备push的index的差，是否超出了滑动窗口的范围，超出了需要poll first
    //3. 添加元素前，还需要从队列的末尾找起，所有，比新元素值小的元素通通poll last
    //4. 添加元素
    //这样维护的双端队列的作用是，永远保证队列头的元素是当前滑动窗口最大值！！
    public static int[] maxInWindow(int[] array, int windowSize) {
        if (array == null || array.length < windowSize || windowSize < 1) {
            return null;
        }
        //双端队列
        int[] maxInWindow = new int[array.length - windowSize + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (deque.isEmpty()) {
                deque.push(i);
                continue;
            }
            if (i - deque.peekFirst() >= windowSize) {
                //超过滑动窗口的大小
                deque.pollFirst();
            }

            while (!deque.isEmpty() && array[deque.getLast()] <= array[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= windowSize - 1) {
                maxInWindow[i - windowSize + 1] = array[deque.peekFirst()];
            }
        }
        return maxInWindow;
    }

    public static int[] minInWindow(int[] array, int windowSize) {
        if (array == null || array.length < windowSize || windowSize < 1) {
            return null;
        }
        //双端队列
        int[] minInWindow = new int[array.length - windowSize + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (deque.isEmpty()) {
                deque.push(i);
                continue;
            }
            if (i - deque.peekFirst() >= windowSize) {
                //超过滑动窗口的大小
                deque.pollFirst();
            }
            //求最小值只需要保证队列头元素是最小的即可
            while (!deque.isEmpty() && array[deque.getLast()] >= array[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= windowSize - 1) {
                minInWindow[i - windowSize + 1] = array[deque.peekFirst()];
            }
        }
        return minInWindow;
    }
}
