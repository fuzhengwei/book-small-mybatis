package cn.bugstack.mybatis.reflection.factory;

import java.util.List;
import java.util.Properties;

/**
 * @author 小傅哥，微信：fustack
 * @description 对象工厂接口
 * @date 2022/5/2
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface ObjectFactory {

    /**
     * Sets configuration properties.
     * 设置属性
     * @param properties configuration properties
     */
    void setProperties(Properties properties);

    /**
     * Creates a new object with default constructor.
     * 生产对象
     * @param type Object type
     * @return <T>
     */
    <T> T create(Class<T> type);

    /**
     * Creates a new object with the specified constructor and params.
     * 生产对象，使用指定的构造函数和构造函数参数
     * @param type Object type
     * @param constructorArgTypes Constructor argument types
     * @param constructorArgs Constructor argument values
     * @return <T>
     */
    <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

    /**
     * Returns true if this object can have a set of other objects.
     * It's main purpose is to support non-java.util.Collection objects like Scala collections.
     * 返回这个对象是否是集合，为了支持 Scala collections
     *
     * @since 3.1.0
     * @param type Object type
     * @return whether it is a collection or not
     */
    <T> boolean isCollection(Class<T> type);

}
