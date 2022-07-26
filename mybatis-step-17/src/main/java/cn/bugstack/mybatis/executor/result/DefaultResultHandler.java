package cn.bugstack.mybatis.executor.result;

import cn.bugstack.mybatis.reflection.factory.ObjectFactory;
import cn.bugstack.mybatis.session.ResultContext;
import cn.bugstack.mybatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 默认结果处理器
 * @date 2022/05/31
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultResultHandler implements ResultHandler {

    private final List<Object> list;

    public DefaultResultHandler() {
        this.list = new ArrayList<>();
    }

    /**
     * 通过 ObjectFactory 反射工具类，产生特定的 List
     */
    @SuppressWarnings("unchecked")
    public DefaultResultHandler(ObjectFactory objectFactory) {
        this.list = objectFactory.create(List.class);
    }

    @Override
    public void handleResult(ResultContext context) {
        list.add(context.getResultObject());
    }

    public List<Object> getResultList() {
        return list;
    }

}
