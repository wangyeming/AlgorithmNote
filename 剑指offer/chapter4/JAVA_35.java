package chapter4;

import support.ComplexListNode;

/**
 * 复杂链表的复制
 * <p>
 * 请实现函数复制一个复杂链表，在复杂链表中，每个节点除了有一个next指针指向下一个节点，
 * 还有一个sibling指针指向链表中的任意节点或null
 * <p>
 * 考察点：复杂问题的思考
 */
public class JAVA_35 {

    public static void main(String[] argv) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);
        ComplexListNode node6 = new ComplexListNode(6);
        ComplexListNode node7 = new ComplexListNode(7);

        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node6;
        node6.nextNode = node7;

        node1.sibling = node3;
        node2.sibling = node5;
        node3.sibling = node7;
        node4.sibling = node1;
        node5.sibling = node2;
        node6.sibling = node6;
        node7.sibling = node2;

        System.out.println("原链表为：");
        printLinkList(node1);

        ComplexListNode cloneHead = cloneComplexLinkList(node1);
        System.out.println("原链表为：");
        printLinkList(node1);
        System.out.println("复制链表为：");
        printLinkList(cloneHead);
    }

    //思路1：第一步复制节点和next，生成新链表，第二步扫描每个节点的复杂指针，然后从头开始找到复杂指针对应的位置
    //再在新链表中找到复杂指针对应的复制节点，重构复杂指针  时间复杂度O(n^2)
    //思路2: 借助O(n)的空间，将原节点和复制节点一一对应上，节省找到复杂节点的位置。
    //时间复杂度O(n) 空间复杂度O(n^2)
    //思路3：巧妙利用复制节点可以插在原节点后面，来保证找到复杂节点的位置的同时，节省空间。
    //时间复杂度O(n) 空间复杂度O(1)
    public static ComplexListNode cloneComplexLinkList(ComplexListNode node) {
        if (node == null) {
            return null;
        }
        cloneNode(node);
        connectSiblingNode(node);
        return reconnectNode(node);
    }

    //步骤1 将链表的节点复制后，插入到原链表节点的后一位
    //1->2->3->4
    //1->1->2->2->3->3->4
    private static void cloneNode(final ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode next = node.nextNode;
            ComplexListNode nodeCopy = new ComplexListNode(node.value);
            nodeCopy.nextNode = next;
            nodeCopy.sibling = null;
            node.nextNode = nodeCopy;
            node = next;
        }
    }

    //步骤2 将复制好的节点，附上原节点的sibling指针
    private static void connectSiblingNode(final ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode copyNode = node.nextNode;
            copyNode.sibling = node.sibling.nextNode;
            node = copyNode.nextNode;
        }
    }

    //步骤3 拆封链表
    private static ComplexListNode reconnectNode(final ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = node.nextNode;
        ComplexListNode cloneNode = cloneHead;
        node.nextNode = cloneNode.nextNode;
        node = cloneNode.nextNode;
        while (node != null) {
            cloneNode = node.nextNode;
            node.nextNode = cloneNode.nextNode;
            node = node.nextNode;
            if (node != null) {
                //注意这里的判空，因为原链表的尾节点的next是新链表的尾节点，而尾节点的next是空
                cloneNode.nextNode = node.nextNode;
            }
        }
        return cloneHead;

    }

    private static void printLinkList(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            System.out.print("node value is " + node.value);
            System.out.print(" next is " + node.nextNode);
            System.out.print(" sibling is " + node.sibling);
            System.out.println();
            node = node.nextNode;
        }
    }
}