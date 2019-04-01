package chapter2;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 * <p>
 * 考察点：链表的操作，栈的利用
 */
public class JAVA_6 {

    public static void main(String[] argv) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;

        System.out.println("栈写法");
        reversePrintLinkedList(node1);
        System.out.println("递归写法");
        reversePrintLinkedList2(node1);
    }

    //栈写法
    public static void reversePrintLinkedList(ListNode firstNode) {
        List<Integer> stack = new ArrayList<>();
        while (firstNode != null) {
            stack.add(firstNode.value);
            firstNode = firstNode.nextNode;
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            int value = stack.get(i);
            System.out.println(value);
        }
    }

    //递归写法，容易栈溢出
    public static void reversePrintLinkedList2(ListNode firstNode) {
        if (firstNode == null) {
            return;
        }
        reversePrintLinkedList2(firstNode.nextNode);
        System.out.println(firstNode.value);
    }
}
