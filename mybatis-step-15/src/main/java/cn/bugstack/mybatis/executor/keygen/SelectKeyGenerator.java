package cn.bugstack.mybatis.executor.keygen;

import cn.bugstack.mybatis.executor.Executor;
import cn.bugstack.mybatis.mapping.MappedStatement;
import cn.bugstack.mybatis.reflection.MetaObject;
import cn.bugstack.mybatis.session.Configuration;
import cn.bugstack.mybatis.session.RowBounds;

import java.sql.Statement;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 键值生成器
 * @date 2022/6/23
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class SelectKeyGenerator implements KeyGenerator {

    public static final String SELECT_KEY_SUFFIX = "!selectKey";
    private boolean executeBefore;
    private MappedStatement keyStatement;

    public SelectKeyGenerator(MappedStatement keyStatement, boolean executeBefore) {
        this.executeBefore = executeBefore;
        this.keyStatement = keyStatement;
    }

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        if (executeBefore) {
            processGeneratedKeys(executor, ms, parameter);
        }
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        if (!executeBefore) {
            processGeneratedKeys(executor, ms, parameter);
        }
    }

    private void processGeneratedKeys(Executor executor, MappedStatement ms, Object parameter) {
        try {
            if (parameter != null && keyStatement != null && keyStatement.getKeyProperties() != null) {
                String[] keyProperties = keyStatement.getKeyProperties();
                final Configuration configuration = ms.getConfiguration();
                final MetaObject metaParam = configuration.newMetaObject(parameter);
                if (keyProperties != null) {
                    Executor keyExecutor = configuration.newExecutor(executor.getTransaction());
                    List<Object> values = keyExecutor.query(keyStatement, parameter, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
                    if (values.size() == 0) {
                        throw new RuntimeException("SelectKey returned no data.");
                    } else if (values.size() > 1) {
                        throw new RuntimeException("SelectKey returned more than one value.");
                    } else {
                        MetaObject metaResult = configuration.newMetaObject(values.get(0));
                        if (keyProperties.length == 1) {
                            if (metaResult.hasGetter(keyProperties[0])) {
                                setValue(metaParam, keyProperties[0], metaResult.getValue(keyProperties[0]));
                            } else {
                                setValue(metaParam, keyProperties[0], values.get(0));
                            }
                        } else {
                            handleMultipleProperties(keyProperties, metaParam, metaResult);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error selecting key or setting result to parameter object. Cause: " + e);
        }
    }

    private void handleMultipleProperties(String[] keyProperties,
                                          MetaObject metaParam, MetaObject metaResult) {
        String[] keyColumns = keyStatement.getKeyColumns();

        if (keyColumns == null || keyColumns.length == 0) {
            for (String keyProperty : keyProperties) {
                setValue(metaParam, keyProperty, metaResult.getValue(keyProperty));
            }
        } else {
            if (keyColumns.length != keyProperties.length) {
                throw new RuntimeException("If SelectKey has key columns, the number must match the number of key properties.");
            }
            for (int i = 0; i < keyProperties.length; i++) {
                setValue(metaParam, keyProperties[i], metaResult.getValue(keyColumns[i]));
            }
        }
    }

    private void setValue(MetaObject metaParam, String property, Object value) {
        if (metaParam.hasSetter(property)) {
            metaParam.setValue(property, value);
        } else {
            throw new RuntimeException("No setter found for the keyProperty '" + property + "' in " + metaParam.getOriginalObject().getClass().getName() + ".");
        }
    }

}
