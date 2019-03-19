package chapter4;

import java.util.Stack;

/**
 * 栈的压入,弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个系列是否为该栈的弹出序列，假设压入栈的所有数字都不相等。
 * <p>
 * 考察点：对栈的理解，分析找出规律
 */
public class JAVA_31 {

    public static void main(String[] argv) {
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
    }

    //思路是：维护一个栈，挨个看pop的元素，如果恰好是栈顶元素，pop之。如果不是，那么就在push数组里找，找不到说明不合法。找到了，要把之前的元素都
    //push到栈中。
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null) {
            return false;
        }
        if (pushOrder.length != popOrder.length) {
            return false;
        }
        //模拟栈的push和pop操作
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        for (int i = 0; i < pushOrder.length; i++) {
            int popNum = popOrder[i];
            //判断当前栈顶元素是否匹配
            if (!stack.isEmpty() && popNum == stack.peek()) {
                //此时栈顶的元素刚好就是pop的元素
                stack.pop();
                continue;
            }
            //去push数组里，去找到当前pop的元素，把之前的元素都push到栈里
            boolean findPushNum = false;
            for (int j = pushIdx; j < pushOrder.length; j++) {
                int pushNum = pushOrder[j];
                if (pushNum == popNum) {
                    findPushNum = true;
                    pushIdx = j + 1;
                    break;
                } else {
                    stack.push(pushNum);
                }
            }
            if (!findPushNum) {
                //没找到的话，说明此时要pop的元素，不合法
                return false;
            }
        }
        return true;
    }
}
