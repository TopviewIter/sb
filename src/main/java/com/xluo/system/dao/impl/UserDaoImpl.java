package com.xluo.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.xluo.frame.dao.impl.BaseDaoImpl;
import com.xluo.system.dao.UserDao;
import com.xluo.system.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public void save(User user){
		sqlSessionTemplate.update("insert into t_user values(1, 'xiaoming')");
	}
	
}
