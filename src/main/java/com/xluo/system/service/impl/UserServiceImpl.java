package com.xluo.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xluo.frame.service.impl.BaseServiceImpl;
import com.xluo.system.dao.UserDao;
import com.xluo.system.po.User;
import com.xluo.system.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource
	private UserDao userDao;
	
	@Resource
	public void setBaseDao(UserDao userDao){
		super.setBaseDao(userDao);
	}

}
