public class JAVA_148 {

    public static void main(String[] argv) {
        ListNode head = new ListNode(8);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("排序前链表为");
        printNode(head);
        sortList(head);
        System.out.println("排序后链表为");
        printNode(head);
    }

    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        quickSort(head, null);
        return head;
    }

    private static void quickSort(ListNode head, ListNode end) {
        ListNode node = partition(head, end);
        if(head != node) {
            quickSort(head, node);
        }
        if(node.next != end) {
            quickSort(node.next, end);
        }
    }

    private static ListNode partition(ListNode head, ListNode end) {
        if (head == null || head.next == null || head == end) {
            return head;
        }
        int pivot = head.val;
        ListNode previous = head;
        ListNode current = head.next;
        while (current != null && current != end) {
            if (current.val < pivot) {
                previous = previous.next;
                if (previous != current) {
                    swap(previous, current);
                }
            }
            current = current.next;
        }
        swap(previous, head);
        return previous;
    }

    private static void swap(ListNode node1, ListNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
