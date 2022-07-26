package cn.bugstack.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 结果集处理器
 * @date 2022/04/26
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}
