package chapter2;

import java.util.Stack;

//用两个栈实现一个队列
public class JAVA_9_1 {

    public static void main(String[] argv) {
        MyQueue myQueue = new MyQueue();
        myQueue.appendTail(1);
        myQueue.appendTail(2);
        myQueue.appendTail(3);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        myQueue.appendTail(4);
        myQueue.appendTail(5);
        myQueue.appendTail(6);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
    }


    public static class MyQueue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void appendTail(Integer value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if(stack2.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return stack2.pop();
        }
    }
}
