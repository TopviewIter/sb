package com.xluo.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xluo.StartWeb;
import com.xluo.system.dao.UserDao;
import com.xluo.system.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartWeb.class)
@WebAppConfiguration
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Test
	public void testSave(){
		userDao.save(new User());
	}
	
	@Test
	public void testSelectAll(){
		Assert.assertEquals(true, userDao.selectAll().size() == 3);
	}

}
