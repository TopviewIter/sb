package com.xluo.frame.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.xluo.frame.dao.BaseDao;
import com.xluo.frame.util.NameSpaceUtil;

/**
 * 
 * Project Name: sb 
 * Class Name: BaseDaoImpl 
 * Desc: 持久层接口实现
 * Date: 2015年11月29日下午12:04:05 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public class BaseDaoImpl<T> implements BaseDao<T>{

	@Resource
	protected SqlSessionTemplate sqlSessionTemplate;

	private static final String SELECTALL = "selectAll";

	public List<T> selectAll() {
		return sqlSessionTemplate.selectList(getStatement(SELECTALL));
	}

	protected String getStatement(String xmlId) {
		return getNameSpace() + "." + xmlId;
	}

	protected String getNameSpace() {
		return NameSpaceUtil.getNameSpace(getEntityClass().getName());
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}
