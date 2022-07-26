package cn.bugstack.mybatis.session;

/**
 * @author 小傅哥，微信：fustack
 * @description 本地缓存机制；
 * SESSION 默认值，缓存一个会话中执行的所有查询
 * STATEMENT 本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不做数据共享
 * @date 2022/7/3
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public enum LocalCacheScope {
    SESSION,
    STATEMENT
}
