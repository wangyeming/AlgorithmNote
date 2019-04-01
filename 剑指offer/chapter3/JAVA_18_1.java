package chapter3;

import base.ListNode;

/**
 * 删除链表的节点
 * <p>
 * 在O(1)的时间内删除链表节点
 * <p>
 * 考察点：链表的编程能力，思维的全面性
 */
public class JAVA_18_1 {

    //不一定要删除节点，可以把下一个节点的值复制过来，然后把指针指向下一个节点的下一个节点处
    public static void deleteNode(ListNode head, ListNode toDeleteNode) {
        if (toDeleteNode.nextNode == null) {
            if (head.nextNode == null) {
                //如果只有一个节点
                head.value = -1;
                return;
            } else {
                //尾节点需要遍历处理,时间复杂度是O(n)
                while (head.nextNode != toDeleteNode) {
                    head = head.nextNode;
                }
                head.nextNode = null;
                return;
            }
        }
        //非尾节点时间复杂度只有O(1)
        toDeleteNode.value = toDeleteNode.nextNode.value;
        toDeleteNode.nextNode = toDeleteNode.nextNode.nextNode;
    }

    public static void main(String[] argv) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        System.out.println("原链表为");
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");

        System.out.println("删除后的链表为");
        node = node1;
        deleteNode(node1, node3);
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");
        System.out.println("--------");
    }

    private static void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;

        System.out.println("原链表为");
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");

        System.out.println("删除后的链表为");
        node = node1;
        deleteNode(node1, node4);
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");
    }

    private static void test3() {
        ListNode node1 = new ListNode(1);

        System.out.println("原链表为");
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println("null");

        System.out.println("删除后的链表为");
        node = node1;
        deleteNode(node1, node1);
        while (node != null) {
            if(node.value != -1) {
                System.out.print(node.value);
            }
            node = node.nextNode;
        }
    }
}