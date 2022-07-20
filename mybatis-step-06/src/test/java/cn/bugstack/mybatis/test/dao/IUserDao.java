package cn.bugstack.mybatis.test.dao;

import cn.bugstack.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
