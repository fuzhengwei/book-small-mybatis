package cn.bugstack.mybatis.mapping;

/**
 * @author 小傅哥，微信：fustack
 * @description SQL源码
 * @date 2022/5/17
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
