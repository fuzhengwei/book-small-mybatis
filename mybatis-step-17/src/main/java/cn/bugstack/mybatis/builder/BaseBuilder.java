package cn.bugstack.mybatis.builder;

import cn.bugstack.mybatis.session.Configuration;
import cn.bugstack.mybatis.type.TypeAliasRegistry;
import cn.bugstack.mybatis.type.TypeHandler;
import cn.bugstack.mybatis.type.TypeHandlerRegistry;

/**
 * @author 小傅哥，微信：fustack
 * @description 构建器的基类，建造者模式
 * @date 2022/04/06
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }

    // 根据别名解析 Class 类型别名注册/事务管理器别名
    protected Class<?> resolveClass(String alias) {
        if (alias == null) {
            return null;
        }
        try {
            return resolveAlias(alias);
        } catch (Exception e) {
            throw new RuntimeException("Error resolving class. Cause: " + e, e);
        }
    }

    protected TypeHandler<?> resolveTypeHandler(Class<?> javaType, Class<? extends TypeHandler<?>> typeHandlerType) {
        if (typeHandlerType == null){
            return null;
        }
        return typeHandlerRegistry.getMappingTypeHandler(typeHandlerType);
    }

}
