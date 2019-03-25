package chapter5;

import support.ListNode;

/**
 * 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出他们的第一个公共节点。
 * <p>
 * 考察点：链表
 */
public class JAVA_52 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node6.nextNode = node7;
        node7.nextNode = node4;

        System.out.println(findFirstCommonNode(node1, node6));
    }

    //先遍历两个链表，分别计算出链表的长度，然后长的那一方先走n步，然后两个一起向后走，每次比较节点是否相同即可
    //相比利用栈的方法，不需要额外的空间
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = 0;
        int length2 = 0;
        ListNode node1 = head1;
        while (node1 != null) {
            node1 = node1.nextNode;
            length1++;
        }
        ListNode node2 = head2;
        while (node2 != null) {
            node2 = node2.nextNode;
            length2++;
        }
        node1 = head1;
        node2 = head2;
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                node1 = node1.nextNode;
            }
        } else if (length1 < length2) {
            for (int i = 0; i < length2 - length1; i++) {
                node2 = node2.nextNode;
            }
        }
        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.nextNode;
            node2 = node2.nextNode;
        }
        return null;
    }

}
