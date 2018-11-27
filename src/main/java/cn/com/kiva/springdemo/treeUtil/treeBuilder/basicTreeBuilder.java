package cn.com.kiva.springdemo.treeUtil.treeBuilder;

import cn.com.kiva.springdemo.treeUtil.treeModel.basicTree;
import cn.com.kiva.springdemo.treeUtil.treeUtilInterface.treeBuilder;

public class basicTreeBuilder implements treeBuilder {

    @Override
    public <s extends basicTree> s getTree() {
        basicTree basicTree = new basicTree();

        return (s) basicTree;

    }
}
