package chapter3;

import support.ListNode;

/**
 * 链表中倒数第k个节点
 * <p>
 * 输出单向链表中倒数第k个节点
 * <p>
 * 考察点：链表的理解，鲁棒性
 */
public class JAVA_22 {

    public static void main(String[] argv) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        System.out.println(getEndKNode(node1, 1));
        System.out.println(getEndKNode(node1, 2));
        System.out.println(getEndKNode(node1, 3));
        System.out.println(getEndKNode(node1, 4));
        System.out.println(getEndKNode(node1, 5));

        System.out.println(getEndKNode(node3, 1));
        System.out.println(getEndKNode(node3, 2));
        System.out.println(getEndKNode(node3, 3));

        System.out.println(getEndKNode(node4, 1));
        System.out.println(getEndKNode(node4, 2));
        System.out.println(getEndKNode(node4, 3));
    }

    //注意鲁棒性，k=0，空指针，或者k超出了链表范围
    public static ListNode getEndKNode(ListNode head, int k) {
        if (k < 1) {
            return null;
        }
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int i = 0;
        while (i < k && node1 != null) {
            node1 = node1.nextNode;
            i++;
        }
        if (i != k) {
            //k大于链表长度
            return null;
        }
        while (node1 != null) {
            node1 = node1.nextNode;
            node2 = node2.nextNode;
        }
        return node2;
    }
}
