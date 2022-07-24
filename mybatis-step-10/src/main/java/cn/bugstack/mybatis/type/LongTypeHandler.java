package cn.bugstack.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小傅哥，微信：fustack
 * @description Long类型处理器
 * @date 2022/5/25
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class LongTypeHandler extends BaseTypeHandler<Long> {

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter);
    }

}
