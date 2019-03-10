package chapter2;

import java.util.ArrayDeque;
import java.util.Queue;

//用两个队列实现一个栈
public class JAVA_9_2 {

    public static void main(String[] argv) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public static class MyStack {
        private Queue<Integer> queue1 = new ArrayDeque<>();
        private Queue<Integer> queue2 = new ArrayDeque<>();

        public void push(Integer value) {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.add(value);
            } else if (queue1.isEmpty()) {
                queue2.add(value);
            } else if (queue2.isEmpty()) {
                queue1.add(value);
            } else {
                throw new RuntimeException("error");
            }
        }

        public Integer pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.remove());
                }
                return queue2.remove();
            } else if (queue2.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.add(queue1.remove());
                }
                return queue1.remove();
            } else {
                throw new RuntimeException("error");
            }
        }
    }
}