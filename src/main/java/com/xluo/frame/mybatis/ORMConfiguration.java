package com.xluo.frame.mybatis;

import javax.annotation.Resource;
import javax.sql.DataSource;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.xluo.frame.util.Constant;

/**
  *  
 * Project Name: sb 
 * Class Name: DataBaseConfiguration 
 * Desc: 持久层框架集成
 * Date: 2015年11月29日下午12:04:29 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
@Configuration
@EnableTransactionManagement
public class ORMConfiguration {

	@Resource
	private DataSourceProperties dataSourceProperties;

	@Bean
	public DataSource dataSource() {
		
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.dataSourceProperties.getClassLoader())
				.url(this.dataSourceProperties.getUrl())
				.username(this.dataSourceProperties.getUsername())
				.password(this.dataSourceProperties.getPassword());
		return new Log4jdbcProxyDataSource(factory.build());
		
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources(Constant.XML_PATH));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplateBean() throws Exception {

		return new SqlSessionTemplate(sqlSessionFactoryBean());

	}

}