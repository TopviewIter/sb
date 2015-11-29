package com.xluo.frame.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * Project Name: sb 
 * Class Name: WordUtil 
 * Desc:
 * Date: 2015年11月28日下午7:09:48 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public class WordUtil {

	private Configuration configuration = null;

	@SuppressWarnings("deprecation")
	public WordUtil() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public static void main(String[] args) {
		WordUtil test = new WordUtil();
		test.createWord();
	}

	public void createWord() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		getData(dataMap);
		configuration.setClassForTemplateLoading(this.getClass(), "/com/xluo/frame/template"); // FTL文件所存在的位置
		Template t = null;
		try {
			t = configuration.getTemplate("test.ftl"); // 文件名
		} catch (IOException e) {
			e.printStackTrace();
		}
		File outFile = new File(Math.random() * 10000
				+ ".doc");
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getData(Map<String, Object> dataMap) {
		dataMap.put("NAME", "韩满义");
		
		dataMap.put("SEX", "男");
		dataMap.put("BIRTH", "1987-08");
		dataMap.put("ZZMM", "党员");
		dataMap.put("MZ", "汉");
		dataMap.put("JG", "河北省");
		dataMap.put("JKZK", "良好");
		dataMap.put("SG", "173cm");
		dataMap.put("HYZK", "已婚");
		dataMap.put("XL", "本科");
		dataMap.put("BYYX", "河北工业大学");
		dataMap.put("ZY", "软件工程");
		dataMap.put("ZP", "照片//todo");
		dataMap.put("QZYX", "软件方向工作薪资1w上下");
		dataMap.put("JYSH1", "06-09-01~10-06-20");
		dataMap.put("JYYZ1", "河北工业大学 软件工程");
		dataMap.put("JYXW1", "学士学位");
		dataMap.put("JYKC1", "软件工程、微积分、软件过程管理、数据库原理等等");
		
		dataMap.put("JYSH2", "10-07-01~至今");
		dataMap.put("JYYZ2", "ABCDE大学");
		dataMap.put("JYXW2", "XYZ学位");
		dataMap.put("JYKC2", "POI课程");

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("number", i);
			map.put("content", "内容" + i);
			list.add(map);
		}

		dataMap.put("list", list);
	}

}
