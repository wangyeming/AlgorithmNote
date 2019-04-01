package chapter1;

import base.ListNode;

/**
 * 判断单向链表是不是回文串
 */
public class java_1_5_2 {

    public static void main(String[] argv) {
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1, 2, 3, 4})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1,1})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1,2,1})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1,2,2,1})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1,2,3,2,1})));
        System.out.println(isPalindrome1LinkList(createLinkList(new int[]{1,2,3,4,2,1})));
        ListNode node = createLinkList(new int[]{1,2,3,3,2,1});
        System.out.println(isPalindrome1LinkList(node));
    }

    //先快慢指针让慢指针走到链表的正中间，然后反转后半部分链表。然后分别从链表头和中间出发进行回文比对
    //1->2->3->3->2->1  =>  1->2->3->1->2->3
    public static boolean isPalindrome1LinkList(ListNode head) {
        if (head == null || head.nextNode == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.nextNode;
        while (fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode;
            if (fast.nextNode == null) {
                break;
            }
            fast = fast.nextNode;
        }
        slow.nextNode = reverseLinkList(slow.nextNode);
        ListNode firstHead = head;
        ListNode secondHead = slow.nextNode;
        while (secondHead != null) {
            if (firstHead.value != secondHead.value) {
                return false;
            }
            firstHead = firstHead.nextNode;
            secondHead = secondHead.nextNode;
        }
        return true;
    }

    private static ListNode reverseLinkList(ListNode head) {
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

    private static ListNode createLinkList(int[] data) {
        ListNode head = new ListNode(data[0]);
        ListNode node = head;
        for (int i = 1; i < data.length; i++) {
            ListNode newNode = new ListNode(data[i]);
            node.nextNode = newNode;
            node = newNode;
        }
        return head;
    }

    private static void printLinkList(ListNode head) {
        System.out.println("链表为");
        ListNode node = head;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");
    }
}
