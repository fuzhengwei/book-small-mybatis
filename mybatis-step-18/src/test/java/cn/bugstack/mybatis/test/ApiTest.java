package cn.bugstack.mybatis.test;

import cn.bugstack.mybatis.io.Resources;
import cn.bugstack.mybatis.session.*;
import cn.bugstack.mybatis.test.dao.IActivityDao;
import cn.bugstack.mybatis.test.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryActivityById() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);

        // 3. 测试验证
        Activity req = new Activity();
        req.setActivityId(100001L);

        logger.info("测试结果：{}", JSON.toJSONString(dao.queryActivityById(req)));

        // 测试时，可以分别开启对应的注释，验证功能逻辑
        // sqlSession.commit();
        // sqlSession.clearCache();
        // sqlSession.close();

        logger.info("测试结果：{}", JSON.toJSONString(dao.queryActivityById(req)));
    }

}
