package cn.bugstack.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 小傅哥，微信：fustack
 * @description 类型处理器
 * @date 2022/5/17
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    /**
     * 获取结果
     */
    T getResult(ResultSet rs, String columnName) throws SQLException;

    /**
     * 取得结果
     */
    T getResult(ResultSet rs, int columnIndex) throws SQLException;

}
