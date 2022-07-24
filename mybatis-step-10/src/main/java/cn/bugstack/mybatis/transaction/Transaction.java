package cn.bugstack.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 小傅哥，微信：fustack
 * @description 事务接口
 * @date 2022/04/13
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
