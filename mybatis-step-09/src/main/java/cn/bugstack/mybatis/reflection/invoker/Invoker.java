package cn.bugstack.mybatis.reflection.invoker;

/**
 * @author 小傅哥，微信：fustack
 * @description 调用者
 * @date 2022/5/2
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
