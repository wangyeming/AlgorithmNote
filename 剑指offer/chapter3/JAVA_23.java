package chapter3;

import support.ListNode;

/**
 * 链表中环的入口节点
 * <p>
 * 如果一个链表中包含环，如何照出环的入口节点
 *
 * 考察点：链表的理解，拆分成子问题的能力
 */
public class JAVA_23 {

    public static void main(String[] argv) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node6;

        node6.nextNode = node3;
        System.out.println(findCircleStart(node1));

        ListNode node7 = new ListNode(7);
        node7.nextNode = node7;
        System.out.println(findCircleStart(node7));
    }

    //1. 判断是否有环 快慢指针
    //2. 计算环的长度 快慢指针相遇于node i，i一定位于环内，原地绕一圈回到原点经过的节点个数即为环的长度k
    //3. 前指针先走k步，后指针再和前指针一起走，相遇处即为环的入口
    public static ListNode findCircleStart(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCircle = false;
        while (true) {
            fast = fast.nextNode;
            if (fast == null) {
                break;
            }
            if (fast == slow) {
                hasCircle = true;
                break;
            }
            fast = fast.nextNode;
            if (fast == null) {
                break;
            }
            if (fast == slow) {
                hasCircle = true;
                break;
            }
            slow = slow.nextNode;
        }
        System.out.println(hasCircle ? "有环" : "无环");
        if (!hasCircle) {
            //无环
            return null;
        }
        System.out.println("相遇点是 " + fast);
        //计算环的长度
        ListNode node = fast;
        node = node.nextNode;
        int i = 1;
        while (node != fast) {
            node = node.nextNode;
            i++;
        }
        System.out.println("环的长度 " + i);
        fast = head;
        slow = head;
        for (int j = 0; j < i; j++) {
            fast = fast.nextNode;
        }
        while (slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        return slow;

    }
}
