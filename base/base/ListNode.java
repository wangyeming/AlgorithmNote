package base;

//链表的节点
public class ListNode {

    public ListNode(int value) {
        this.value = value;
    }

    public int value;
    public ListNode nextNode = null;

    @Override
    public String toString() {
        return "" + value;
    }
}
