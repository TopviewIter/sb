package com.xluo.frame.util;

public class NameSpaceUtil {

	public static String getNameSpace(String entityClassName){
		return Constant.PRE_NS + entityClassName.substring(entityClassName.lastIndexOf(".")) + "Mapper";
	}
	
}
