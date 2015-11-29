package com.xluo.system.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xluo.frame.controller.BaseController;
import com.xluo.frame.util.ExcelUtils;
import com.xluo.system.po.User;
import com.xluo.system.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/cache")
	@ResponseBody
	@Cacheable(value = "user")
	public List<User> cache() {
		return userService.selectAll();
	}
	
	@RequestMapping("/download")
	public void getExcel(HttpServletResponse response) throws IOException{
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
		ajaxdownLoad(response, "test.xsl", is);
	}

}
