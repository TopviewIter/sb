package com.xluo.frame.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

import com.xluo.system.po.User;

public class ExcelUtilsTest {

	@Test
	public void testGetInputStream(){
		User user = new User();
		user.setId(1L);
		user.setName("xiaoming");
		List<User> users = new ArrayList<User>();
		users.add(user);
		ExcelUtils excelUtil = new ExcelUtils();
		Map<String, String> heads = new HashMap<String, String>();
		heads.put("id", "id");
		heads.put("name", "姓名");
		HSSFWorkbook work = excelUtil.createHSSFWorkbook("test", null, users, heads, null);
		InputStream is = excelUtil.getInputStream(excelUtil.createHSSFWorkbook("test2", null, users, heads, work));
		Assert.assertEquals(true, is != null);
//		ajaxdownLoad(response, "test.xsl", is);
	}

}
