package com.xluo.frame.service;

import java.util.List;

/**
  * 
 * Project Name: sb 
 * Class Name: BaseService 
 * Desc: 服务层统一接口
 * Date: 2015年11月29日下午12:06:46 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public interface BaseService<T> {

	public List<T> selectAll();
	
}
