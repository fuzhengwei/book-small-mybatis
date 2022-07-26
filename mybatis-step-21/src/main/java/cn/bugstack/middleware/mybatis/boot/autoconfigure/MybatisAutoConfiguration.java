package cn.bugstack.middleware.mybatis.boot.autoconfigure;

import cn.bugstack.middleware.mybatis.boot.spring.MapperFactoryBean;
import cn.bugstack.middleware.mybatis.boot.spring.MapperScannerConfigurer;
import cn.bugstack.mybatis.io.Resources;
import cn.bugstack.mybatis.session.SqlSessionFactory;
import cn.bugstack.mybatis.session.SqlSessionFactoryBuilder;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.xml.sax.InputSource;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnClass({SqlSessionFactory.class})
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisAutoConfiguration implements InitializingBean {

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(MybatisProperties mybatisProperties) throws Exception {

        Document document = DocumentHelper.createDocument();

        Element configuration = document.addElement("configuration");

        Element environments = configuration.addElement("environments");
        environments.addAttribute("default", "development");

        Element environment = environments.addElement("environment");
        environment.addAttribute("id", "development");
        environment.addElement("transactionManager").addAttribute("type", "JDBC");
        ;

        Element dataSource = environment.addElement("dataSource");
        dataSource.addAttribute("type", "POOLED");

        dataSource.addElement("property").addAttribute("name", "driver").addAttribute("value", mybatisProperties.getDriver());
        dataSource.addElement("property").addAttribute("name", "url").addAttribute("value", mybatisProperties.getUrl());
        dataSource.addElement("property").addAttribute("name", "username").addAttribute("value", mybatisProperties.getUsername());
        dataSource.addElement("property").addAttribute("name", "password").addAttribute("value", mybatisProperties.getPassword());

        Element mappers = configuration.addElement("mappers");
        mappers.addElement("mapper").addAttribute("resource", mybatisProperties.getMapperLocations());

        return new SqlSessionFactoryBuilder().build(document);
    }

    public static class AutoConfiguredMapperScannerRegistrar implements EnvironmentAware, ImportBeanDefinitionRegistrar {

        private String basePackage;

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MapperScannerConfigurer.class);
            builder.addPropertyValue("basePackage", basePackage);
            registry.registerBeanDefinition(MapperScannerConfigurer.class.getName(), builder.getBeanDefinition());
        }

        @Override
        public void setEnvironment(Environment environment) {
            this.basePackage = environment.getProperty("mybatis.datasource.base-dao-package");
        }
    }

    @Configuration
    @Import(AutoConfiguredMapperScannerRegistrar.class)
    @ConditionalOnMissingBean({MapperFactoryBean.class, MapperScannerConfigurer.class})
    public static class MapperScannerRegistrarNotFoundConfiguration implements InitializingBean {

        @Override
        public void afterPropertiesSet() {
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

}
