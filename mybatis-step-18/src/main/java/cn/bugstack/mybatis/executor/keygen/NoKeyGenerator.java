package cn.bugstack.mybatis.executor.keygen;

import cn.bugstack.mybatis.executor.Executor;
import cn.bugstack.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @author 小傅哥，微信：fustack
 * @description 不用键值生成器
 * @date 2022/6/23
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
