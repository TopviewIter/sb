package com.xluo.system.dao;

import com.xluo.frame.dao.BaseDao;
import com.xluo.system.po.User;

public interface UserDao extends BaseDao<User>{

	public void save(User user);

}
