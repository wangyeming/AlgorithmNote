package chapter3;

import base.ListNode;

/**
 * s
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
        ListNode meetingNode = meetingNode(head);
        if(meetingNode == null) {
            return null;
        }
        int loopLength = geLoopLength(meetingNode);
        ListNode slow = head, fast = head;
        for(int i= 0;i < loopLength;i++) {
            fast = fast.nextNode;
        }
        while(fast != slow) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        return slow;
    }

    private static ListNode meetingNode(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.nextNode;
        while(fast != null && slow != null) {
            if(fast == slow) {
                return fast;
            }
            slow = slow.nextNode;
            fast = fast.nextNode;
            if(fast != null) {
                fast = fast.nextNode;
            }
        }
        return null;
    }

    private static int geLoopLength(ListNode nodeInLoop) {
        ListNode loopNode = nodeInLoop.nextNode;
        int loopLength = 1;
        for(;loopNode != nodeInLoop;loopLength++) {
            loopNode = loopNode.nextNode;
        }
        return loopLength;
    }
}
