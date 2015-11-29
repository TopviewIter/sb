package com.xluo.frame.dao;

import java.util.List;

/**
 * 
 * Project Name: sb 
 * Class Name: BaseDao 
 * Desc: 持久层统一接口
 * Date: 2015年11月29日下午12:03:31 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public interface BaseDao<T> {

	public List<T> selectAll();
	
}
