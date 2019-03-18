package chapter4;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，实现能找到栈里面最小元素的min函数，min函数，pop函数，push函数时间复杂度都是O(1)
 * <p>
 * 考察点：栈的理解
 */
public class JAVA_30 {

    public static void main(String[] argv) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    //辅助栈的作用是，标记当前位置到栈底的最小值，保证无论栈的元素push还是pop，都可以随时拿到最小值
    //[3,3,2,1]
    //[3,4,2,1]
    static class MinStack {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int value) {
            if (stack1.isEmpty() || value < stack1.peek()) {
                stack2.push(value);
            } else {
                stack2.push(stack1.peek());
            }
            stack1.push(value);
        }

        public int pop() {
            if (stack1.isEmpty() || stack2.isEmpty()) {
                throw new EmptyStackException();

            }
            stack2.pop();
            return stack1.pop();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
