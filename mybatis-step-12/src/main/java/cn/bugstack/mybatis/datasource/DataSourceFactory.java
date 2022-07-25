package cn.bugstack.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 小傅哥，微信：fustack
 * @description 数据源工厂
 * @date 2022/04/13
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
