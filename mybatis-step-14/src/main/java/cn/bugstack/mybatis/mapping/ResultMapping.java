package cn.bugstack.mybatis.mapping;

import cn.bugstack.mybatis.session.Configuration;
import cn.bugstack.mybatis.type.JdbcType;
import cn.bugstack.mybatis.type.TypeHandler;

/**
 * @author 小傅哥，微信：fustack
 * @description 结果映射
 * @date 2022/05/31
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
