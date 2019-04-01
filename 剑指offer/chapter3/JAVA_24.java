package chapter3;

import base.ListNode;

/**
 * 反转链表
 * <p>
 * 输入链表头结点，反转之后返回新的链表的头结点
 * <p>
 * 考察点：链表，指针
 */
public class JAVA_24 {

    public static void main(String[] argv) {
        test(new int[]{1, 2, 3, 4, 5, 6});
        test(new int[]{1, 2});
        test(new int[]{1});
        test(new int[]{});
    }

    //1->2->3->...->m -> m+1->...->n
    //当反转到第m个节点是，m+1节点需要以前保存
    //1<-2<-3<-...<-m  m+1->...->n
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.nextNode;
        pre.nextNode = null;

        while (next != null) {
            ListNode tmp = next.nextNode;
            next.nextNode = pre;

            pre = next;
            next = tmp;
        }
        return pre;
    }

    //递归写法
    public static ListNode reverseLinkedListRecursive(ListNode head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        return _reverseLinkedListRecursive(null, head);
    }

    private static ListNode _reverseLinkedListRecursive(ListNode node, ListNode next) {
        if(next == null) {
            return node;
        }
        ListNode newHead = _reverseLinkedListRecursive(next, next.nextNode);
        next.nextNode = node;
        return newHead;
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

//        ListNode newHead = reverseLinkedList(lastNode);
        ListNode newHead = reverseLinkedListRecursive(lastNode);

        System.out.println("反转链表为");
        while (newHead != null) {
            System.out.print(newHead.value + "->");
            newHead = newHead.nextNode;
        }
        System.out.println("null");
    }
}