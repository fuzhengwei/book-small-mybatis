package cn.bugstack.mybatis.executor.statement;

import cn.bugstack.mybatis.executor.Executor;
import cn.bugstack.mybatis.mapping.BoundSql;
import cn.bugstack.mybatis.mapping.MappedStatement;
import cn.bugstack.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 简单语句处理器（STATEMENT）
 * @date 2022/04/26
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SimpleStatementHandler extends BaseStatementHandler {

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }

}
