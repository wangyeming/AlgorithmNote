package chapter6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 队列的最大值
 * <p>
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max，push_back和pop_front的时间复杂度都是O(1)
 * <p>
 * 考察点：滑动窗口
 */
public class JAVA_59_2 {
    public static void main(String[] args) {
        QueueWithMax queueWithMax = new QueueWithMax();
        queueWithMax.push_back(2);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(3);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(4);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(2);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(6);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(2);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(5);
        System.out.println(queueWithMax.max());
        queueWithMax.push_back(1);
        System.out.println(queueWithMax.max());
        System.out.println("------------");
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
        System.out.println("pop " + queueWithMax.pop_front());
        System.out.println(queueWithMax.max());
    }

    public static class QueueWithMax {

        private Deque<Integer> data;
        private Deque<Integer> maxs;
        private int currentIndex = 0;

        public QueueWithMax() {
            data = new ArrayDeque<>();
            maxs = new ArrayDeque<>();
        }


        public void push_back(Integer element) {
            while (!maxs.isEmpty() && element > maxs.peekLast()) {
                maxs.pollLast();
            }
            data.add(element);
            maxs.add(element);
            currentIndex++;
        }

        public Integer pop_front() {
            if (data.isEmpty()) {
                return null;
            }
            if (maxs.peekFirst().equals(data.peekFirst())) {
                maxs.pollFirst();
            }
            return data.pollFirst();
        }

        public Integer max() {
            if (maxs.isEmpty()) {
                return null;
            }
            return maxs.peekFirst();
        }
    }


}
