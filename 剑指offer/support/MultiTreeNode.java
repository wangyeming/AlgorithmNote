package support;

import java.util.ArrayList;
import java.util.List;

//普通树的节点(无父节点)
public class MultiTreeNode {

    public int value;

    public List<MultiTreeNode> nodes = new ArrayList<>();

    public MultiTreeNode() {
    }

    public MultiTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
