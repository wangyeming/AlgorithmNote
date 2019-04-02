package base;

//二叉树的节点(无父节点)
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
