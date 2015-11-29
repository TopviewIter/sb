package com.xluo.frame.service.impl;

import java.util.List;

import com.xluo.frame.dao.BaseDao;
import com.xluo.frame.service.BaseService;

/**
  * 
 * Project Name: sb 
 * Class Name: BaseServiceImpl 
 * Desc: 服务层实现
 * Date: 2015年11月29日下午12:06:15 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public class BaseServiceImpl<T> implements BaseService<T>{

	private BaseDao<T> baseDao;
		
	public void setBaseDao(BaseDao<T> baseDao){
		this.baseDao = baseDao;
	}
	
	@Override
	public List<T> selectAll() {
		return baseDao.selectAll();
	}
	
}
