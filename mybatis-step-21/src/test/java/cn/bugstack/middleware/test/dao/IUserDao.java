package cn.bugstack.middleware.test.dao;

import cn.bugstack.middleware.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
