package cn.bugstack.mybatis.session;

import cn.bugstack.mybatis.builder.xml.XMLConfigBuilder;
import cn.bugstack.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author 小傅哥，微信：fustack
 * @description 构建SqlSessionFactory的工厂
 * @date 2022/04/06
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
