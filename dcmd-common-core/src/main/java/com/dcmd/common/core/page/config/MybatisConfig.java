/**
 * Copy Right Information : 数云 <br>
 * Project : 数云指挥系统 <br>
 * Description : 分页参数类<br>
 * Author : 朱彪 <br>
 * Maintainer:  <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018-03-20<br>
 * Update:  <br>
 */
package com.dcmd.common.core.page.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration//申明这是一个配置
@MapperScan("com.dcmd.common.core.page")
public class MybatisConfig {
	
	@Autowired
	private DataSource dataSource;
	
    @Bean
    @ConditionalOnMissingBean //当容器里没有指定的Bean的情况下创建该对象    dataSource自动注入
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mybatis的主配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        //设置resources下mybatis的xml
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.dcmd.common.core.page");
        return sqlSessionFactoryBean;
    }
}