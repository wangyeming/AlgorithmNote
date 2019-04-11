/**
 * 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Java_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode newHead = null;
        for (ListNode node : lists) {
            newHead = mergeTwoList(node, newHead);
        }
        return newHead;
    }

    public static ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        }

        ListNode mergeHead = null;
        if (listNode1.val <= listNode2.val) {
            mergeHead = listNode1;
            listNode1 = listNode1.next;
        } else {
            mergeHead = listNode2;
            listNode2 = listNode2.next;
        }
        ListNode node = mergeHead;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                node.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                node.next = listNode2;
                listNode2 = listNode2.next;
            }
            node = node.next;
        }
        node.next = listNode1 != null ? listNode1 : listNode2;
        return mergeHead;
    }

    // private static ListNode mergeTwoList(ListNode head1, ListNode head2) {
    //     if(head1 == null) return head2;
    //     if(head2 == null) return head1;
    //     ListNode newHead = null;
    //     if(head1.val <= head2.val) {
    //         newHead = head1;
    //         newHead.next = mergeTwoList(head1.next, head2);
    //     } else {
    //         newHead = head2;
    //         newHead.next = mergeTwoList(head1, head2.next);
    //     }
    //     return newHead;
    // }
}
