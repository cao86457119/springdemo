package cn.com.kiva.springdemo.treeUtil.treeModel;

import java.io.Serializable;

public class basicTree implements Serializable {
    private String treeName;
    private String treeId;
    private basicTreeNode rootNode;


    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public basicTreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(basicTreeNode rootNode) {
        this.rootNode = rootNode;
    }
}
