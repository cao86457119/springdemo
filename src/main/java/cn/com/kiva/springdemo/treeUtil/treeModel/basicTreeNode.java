package cn.com.kiva.springdemo.treeUtil.treeModel;

import java.io.Serializable;
import java.util.ArrayList;

public class basicTreeNode implements Serializable {
    private String treeNodeName;
    private String treeNodeId;
    private ArrayList<basicTreeNode> childrenTreeNodes;


    public String getTreeNodeName() {
        return treeNodeName;
    }

    public void setTreeNodeName(String treeNodeName) {
        this.treeNodeName = treeNodeName;
    }

    public String getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(String treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public ArrayList<basicTreeNode> getChildrenTreeNode() {
        return childrenTreeNodes;
    }

    public void setChildrenTreeNode(ArrayList<basicTreeNode> childrenTreeNode) {
        this.childrenTreeNodes = childrenTreeNode;
    }
}
