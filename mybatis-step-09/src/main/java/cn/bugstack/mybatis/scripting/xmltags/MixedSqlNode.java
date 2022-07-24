package cn.bugstack.mybatis.scripting.xmltags;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 混合SQL节点
 * @date 2022/5/17
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class MixedSqlNode implements SqlNode {

    //组合模式，拥有一个SqlNode的List
    private List<SqlNode> contents;

    public MixedSqlNode(List<SqlNode> contents) {
        this.contents = contents;
    }

    @Override
    public boolean apply(DynamicContext context) {
        // 依次调用list里每个元素的apply
        contents.forEach(node -> node.apply(context));
        return true;
    }

}
