package cn.bugstack.middleware.mybatis.spring.test.dao;

import cn.bugstack.middleware.mybatis.spring.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Activity activity);

}
