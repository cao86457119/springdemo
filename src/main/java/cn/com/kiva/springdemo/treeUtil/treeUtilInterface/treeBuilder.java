package cn.com.kiva.springdemo.treeUtil.treeUtilInterface;

import cn.com.kiva.springdemo.treeUtil.treeModel.basicTree;

public interface treeBuilder {
    <s extends basicTree> s getTree();
}
