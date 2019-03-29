package support;

//二叉树的节点(有父节点)
public class BinaryTreeNode2 {

    public int value;

    public BinaryTreeNode2 parentNode = null;

    public BinaryTreeNode2 leftNode = null;

    public BinaryTreeNode2 rightNode = null;

    public BinaryTreeNode2(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
