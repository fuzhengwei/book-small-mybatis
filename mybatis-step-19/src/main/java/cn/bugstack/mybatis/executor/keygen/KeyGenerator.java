package cn.bugstack.mybatis.executor.keygen;

import cn.bugstack.mybatis.executor.Executor;
import cn.bugstack.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @author 小傅哥，微信：fustack
 * @description 键值生成器接口
 * @date 2022/6/23
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface KeyGenerator {

    /**
     * 针对Sequence主键而言，在执行insert sql前必须指定一个主键值给要插入的记录，
     * 如Oracle、DB2，KeyGenerator提供了processBefore()方法。
     */
    void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter);

    /**
     * 针对自增主键的表，在插入时不需要主键，而是在插入过程自动获取一个自增的主键，
     * 比如MySQL、PostgreSQL，KeyGenerator提供了processAfter()方法
     */
    void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter);

}