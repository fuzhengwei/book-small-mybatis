package cn.bugstack.mybatis.reflection;

import cn.bugstack.mybatis.reflection.factory.DefaultObjectFactory;
import cn.bugstack.mybatis.reflection.factory.ObjectFactory;
import cn.bugstack.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import cn.bugstack.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @author 小傅哥，微信：fustack
 * @description 一些系统级别的元对象
 * @date 2022/5/2
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SystemMetaObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

    private SystemMetaObject() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 空对象
     */
    private static class NullObject {
    }

    public static MetaObject forObject(Object object) {
        return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
    }

}
