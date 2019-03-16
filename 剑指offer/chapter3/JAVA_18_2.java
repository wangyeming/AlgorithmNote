package chapter3;

import support.ListNode;

/**
 * 删除链表中重复的节点
 * <p>
 * 在一个排序的链表中，如何删除重复节点。
 * <p>
 * 考察点：链表的结构，综合考虑重复节点所处的位置
 */
public class JAVA_18_2 {

    public static void main(String[] argv) {
        test(new int[]{});
        test(new int[]{1});
        test(new int[]{1, 2, 3, 3, 4, 4, 5});
        test(new int[]{1, 2, 2, 3, 3});
        test(new int[]{2, 2, 2});
        test(new int[]{2, 2, 3, 3,});
        test(new int[]{2, 2, 3, 3, 4});
        test(new int[]{2, 2, 3, 3, 4, 5});
    }

    //因为头结点也可能重复，所以，我们返回值是新的头节点
    public static ListNode deleteRepeatNode(ListNode headNode) {
        if (headNode == null) {
            return null;
        }
        if (headNode.nextNode == null) {
            return headNode;
        }
        ListNode newHeadNode = new ListNode(headNode.value - 1);
        newHeadNode.nextNode = headNode;
        ListNode preNode = newHeadNode;
        ListNode node = preNode.nextNode;
        while (node != null && node.nextNode != null) {
            int value = node.value;
            if (node.nextNode.value == value) {
                //如果当前节点的值和下一个节点的值相同，表示是重复节点
                while (node != null && node.value == value) {
                    node = node.nextNode;
                }
                //上一个节点->指向下一个值不同的节点
                preNode.nextNode = node;
            } else {
                node = node.nextNode;
                preNode = preNode.nextNode;
            }
        }
        return newHeadNode.nextNode;
    }

    private static void test(int[] nodeValues) {
        ListNode lastNode = null;
        for (int i = nodeValues.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(nodeValues[i]);
            listNode.nextNode = lastNode;
            lastNode = listNode;
        }

        System.out.println("原链表为");
        ListNode node = lastNode;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");

        System.out.println("删除后的链表为");
        node = deleteRepeatNode(lastNode);
        while (node != null) {
            if (node.value != -1) {
                System.out.print(node.value + "->");
            }
            node = node.nextNode;
        }
        System.out.println("null");
        System.out.println("--------");
    }
}