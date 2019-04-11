package chapter3;

import base.ListNode;

/**
 * 合并两个排序链表
 * <p>
 * 考察点：递归分析
 */
public class JAVA_25 {

    public static void main(String[] argv) {
        test(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        test(new int[]{1, 3, 5}, new int[]{6});
        test(new int[]{1, 3, 5}, new int[]{});
        test(new int[]{}, new int[]{});
        test(new int[]{1}, new int[]{});
        test(new int[]{1, 3, 5}, new int[]{4});
        test(new int[]{1, 3, 5}, new int[]{3, 5});
        test(new int[]{1}, new int[]{2});
    }

    public static ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        }

        ListNode mergeHead = null;
        if (listNode1.value < listNode2.value) {
            mergeHead = listNode1;
            mergeHead.nextNode = merge(listNode1.nextNode, listNode2);
        } else {
            mergeHead = listNode2;
            mergeHead.nextNode = merge(listNode1, listNode2.nextNode);
        }
        return mergeHead;
    }

    public static ListNode merge2(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        }

        ListNode mergeHead = null;
        if (listNode1.value <= listNode2.value) {
            mergeHead = listNode1;
            listNode1 = listNode1.nextNode;
        } else {
            mergeHead = listNode2;
            listNode2 = listNode2.nextNode;
        }
        ListNode node = mergeHead;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.value <= listNode2.value) {
                node.nextNode = listNode1;
                listNode1 = listNode1.nextNode;
            } else {
                node.nextNode = listNode2;
                listNode2 = listNode2.nextNode;
            }
            node = node.nextNode;
        }
        node.nextNode = listNode1 != null ? listNode1 : listNode2;
        return mergeHead;
    }

    private static void test(int[] nodeValues1, int[] nodeValues2) {
        ListNode lastNode1 = null;
        for (int i = nodeValues1.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(nodeValues1[i]);
            listNode.nextNode = lastNode1;
            lastNode1 = listNode;
        }

        ListNode lastNode2 = null;
        for (int i = nodeValues2.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(nodeValues2[i]);
            listNode.nextNode = lastNode2;
            lastNode2 = listNode;
        }

        System.out.println("原链表1为");
        ListNode node1 = lastNode1;
        while (node1 != null) {
            System.out.print(node1.value + "->");
            node1 = node1.nextNode;
        }
        System.out.println("null");

        System.out.println("原链表2为");
        ListNode node2 = lastNode2;
        while (node2 != null) {
            System.out.print(node2.value + "->");
            node2 = node2.nextNode;
        }
        System.out.println("null");

//        ListNode newHead = reverseLinkedList(lastNode);
        ListNode newHead = merge2(lastNode1, lastNode2);

        System.out.println("合并链表为");
        while (newHead != null) {
            System.out.print(newHead.value + "->");
            newHead = newHead.nextNode;
        }
        System.out.println("null");
    }

}
