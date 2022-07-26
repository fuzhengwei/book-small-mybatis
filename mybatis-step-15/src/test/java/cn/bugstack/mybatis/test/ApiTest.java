package cn.bugstack.mybatis.test;

import cn.bugstack.mybatis.builder.xml.XMLConfigBuilder;
import cn.bugstack.mybatis.executor.Executor;
import cn.bugstack.mybatis.io.Resources;
import cn.bugstack.mybatis.mapping.Environment;
import cn.bugstack.mybatis.session.*;
import cn.bugstack.mybatis.session.defaults.DefaultSqlSession;
import cn.bugstack.mybatis.test.dao.IActivityDao;
import cn.bugstack.mybatis.test.po.Activity;
import cn.bugstack.mybatis.transaction.Transaction;
import cn.bugstack.mybatis.transaction.TransactionFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @date 2022/3/26
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test_queryActivityById() {
        // 1. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);
        // 2. 测试验证
        Activity res = dao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

    @Test
    public void test_insert() {
        // 1. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);

        Activity activity = new Activity();
        activity.setActivityId(10004L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("测试数据插入");
        activity.setCreator("xiaofuge");

        // 2. 测试验证
        Integer res = dao.insert(activity);
        sqlSession.commit();

        logger.info("测试结果：count：{} idx：{}", res, JSON.toJSONString(activity.getId()));
    }

    @Test
    public void test_insert_select() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        final Environment environment = configuration.getEnvironment();
        TransactionFactory transactionFactory = environment.getTransactionFactory();
        Transaction tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);

        // 创建执行器
        final Executor executor = configuration.newExecutor(tx);
        SqlSession sqlSession = new DefaultSqlSession(configuration, executor);

        // 执行查询：默认是一个集合参数
        Activity activity = new Activity();
        activity.setActivityId(10004L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("测试数据插入");
        activity.setCreator("xiaofuge");
        int res = sqlSession.insert("cn.bugstack.mybatis.test.dao.IActivityDao.insert", activity);

        Object obj = sqlSession.selectOne("cn.bugstack.mybatis.test.dao.IActivityDao.insert!selectKey");
        logger.info("测试结果：count：{} idx：{}", res, JSON.toJSONString(obj));

        sqlSession.commit();
    }


}
