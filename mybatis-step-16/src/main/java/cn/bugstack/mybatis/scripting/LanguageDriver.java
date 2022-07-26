package cn.bugstack.mybatis.scripting;

import cn.bugstack.mybatis.executor.parameter.ParameterHandler;
import cn.bugstack.mybatis.mapping.BoundSql;
import cn.bugstack.mybatis.mapping.MappedStatement;
import cn.bugstack.mybatis.mapping.SqlSource;
import cn.bugstack.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author 小傅哥，微信：fustack
 * @description 脚本语言驱动
 * @date 2022/5/17
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建SQL源码(annotation 注解方式)
     */
    SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
