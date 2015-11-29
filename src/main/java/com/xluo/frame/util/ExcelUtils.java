package com.xluo.frame.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * Project Name: sb 
 * Class Name: ExcelUtils 
 * Desc: Excel操纵工具类
 * Date: 2015年11月28日下午6:33:59 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public class ExcelUtils {

	private HSSFSheet hssfSheet;
	private int index = 0;

	/**
	 * 获得文件的流
	 * @param hssfWorkbook
	 * @return
	 */
	public <T> InputStream getInputStream(HSSFWorkbook hssfWorkbook) {

		ByteArrayInputStream inputStream = null;
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
			hssfWorkbook.write(outputStream);
			inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	/**
	 * @param sheetName: 表格名
	 * @param instruction：额外的表头,它不包含在po当中
	 * @param objects：一个List数据集，如:List<User>
	 * @param headerNames：表头信息(po字段名 － sheet显示名)
	 * @param hssfWorkbook：如果只需要一个sheet,直接传null,想要在同一个文件建多个sheet就把
	 * 		createHSSFWrokbook返回的对象传进来
	 * @return
	 */
	public <T> HSSFWorkbook createHSSFWorkbook(String sheetName,
			String[] instruction, List<T> objects,
			Map<String, String> headerNames, HSSFWorkbook hssfWorkbook) {
		
		if(hssfWorkbook == null){
			hssfWorkbook = new HSSFWorkbook();
		}
		index = 0;
		hssfSheet = hssfWorkbook.createSheet(sheetName);
		createHeader(instruction, headerNames);
		setContent(objects, headerNames);
		
		return hssfWorkbook;
	}

	private void createHeader(String[] instruction,
			Map<String, String> headerNames) {
		HSSFRow header = hssfSheet.createRow(index++);

		if (null != instruction && 0 != instruction.length) {
			for (int i = 0; i < instruction.length; i++) {
				HSSFCell hssfCell = header.createCell(i);
				hssfCell.setCellValue(instruction[i]);
			}
			header = hssfSheet.createRow(index++);
		}

		int i = 0;
		for (String head : headerNames.values()) {
			HSSFCell hssfCell = header.createCell(i++);
			hssfCell.setCellValue(head);
		}
	}

	private String[] getMethodNames(Map<String, String> headerNames) {
		String[] methodNames = null;
		if (null != headerNames) {
			methodNames = new String[headerNames.size()];
			int i = 0;
			for (String head : headerNames.keySet()) {
				String methodName = "get" + head.substring(0, 1).toUpperCase()
						+ head.substring(1);
				methodNames[i++] = methodName;
			}
		}
		return methodNames;
	}

	private <T> void setContent(List<T> objects, Map<String, String> headerNames) {
		String[] methodNames = getMethodNames(headerNames);
		for (int i = 0; i < objects.size(); i++) {
			HSSFRow hssfRow = hssfSheet.createRow(index++);

			for (int j = 0; j < headerNames.size(); j++) {
				HSSFCell hssfCell = hssfRow.createCell(j);

				try {

					Method method = objects.get(i).getClass()
							.getMethod(methodNames[j], new Class[] {});
					String value = null == method.invoke(objects.get(i),
							new Object[] {}) ? null : method.invoke(
							objects.get(i), new Object[] {}).toString();
					hssfCell.setCellValue(value);

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

}