package com.xluo.frame.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xluo.system.po.User;

public class SysErrorLogUtilTest {

	@Test
	public void print(){
		
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		SysErrorLogUtil.error(users);
		
	}
	
	@Test
	public void print_01(){
		
		User user = new User();
		user.setId(1L);
		user.setName("xiaoming");
		SysErrorLogUtil.error(user);
		
	}
	
	@Test
	public void print_02(){

		Integer a = null;
		Integer b = null;
		try{
			a = 10;
			b = 0;
			double result = a / b;
			Assert.assertEquals(false, result == 0);
		}catch(Exception e){
			SysErrorLogUtil.error(e, b);
		}
		
		
	}
	
}
