package cn.com.kiva.springdemo.treeUtil.treeBuilder;

import cn.com.kiva.springdemo.treeUtil.treeUtilInterface.treeBuilder;
import cn.com.kiva.springdemo.treeUtil.treeUtilInterface.treeBuilderFactory;

public class basicTreeBuilderFactory implements treeBuilderFactory {

    basicTreeBuilder basicTreeBuilder=null;


    @Override
    public  treeBuilder getTreeBuilder() {

        return basicTreeBuilder;
    }

    public static  basicTreeBuilderFactory getInstance(){
        return factoryHelper.bs;
    }

    static class factoryHelper{
        static final basicTreeBuilderFactory bs= new basicTreeBuilderFactory();


    }


}
