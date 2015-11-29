package com.xluo.frame.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xluo.frame.util.Constant;

/**
 * 
 * Project Name: sb 
 * Class Name: ErrorHandleController 
 * Desc: 指定错误页面
 * Date: 2015年11月29日下午12:44:54 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
@Controller
public class ErrorHandleController implements ErrorController {

	@Override
	public String getErrorPath() {
		return Constant.ERROR_PATH;
	}
	
	@RequestMapping("/error")
	public String errorHandle(){
		return getErrorPath();
	}

}
