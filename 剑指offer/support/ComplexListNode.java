package support;

public class ComplexListNode {

    public ComplexListNode(int value) {
        this.value = value;
    }

    public int value;
    public ComplexListNode nextNode = null;
    public ComplexListNode sibling = null;

    @Override
    public String toString() {
        return "" + value;
    }
}
