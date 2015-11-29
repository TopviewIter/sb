package com.xluo.frame.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.xluo.frame.util.SysErrorLogUtil;

/**
 * 
 * Project Name: sb 
 * Class Name: BaseController 
 * Desc: 基础控制器
 * Date: 2015年11月29日下午12:02:38 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public abstract class BaseController {

	public void ajaxdownLoad(HttpServletResponse response, String fileName, InputStream fileInputStream) {
		try {
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			response.setDateHeader("Expires", 0);
			// 得到响应的输出流 即向客户端输出信息的输出流。
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			byte[] b = new byte[1024];
			int len;

			while ((len = fileInputStream.read(b)) > 0) {
				servletOutputStream.write(b, 0, len);
			}
			response.setStatus(HttpServletResponse.SC_OK);
			response.flushBuffer();
			servletOutputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			SysErrorLogUtil.error(e);
		}
	}

}
