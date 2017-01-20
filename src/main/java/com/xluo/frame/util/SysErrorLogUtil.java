package com.xluo.frame.util;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * <p>
 * 系统错误日志工具类，系统业务模块异常全部记录于此
 * <li>建议只使用此工具类统一访问使用“系统错误日志”
 * <li>尽量使用error(Exception e, Object... obj)方法，即把异常也记录下来
 *
 */
public class SysErrorLogUtil {

	private static Logger logger = Logger.getLogger(Constant.LOGGER_NAME);

	/**
	 * <p>
	 * 可以直接传入pojo对象，该方法会通过反射将pojo对象的结构打印出来
	 * <p>
	 * 建议调试或者异常时，除了将异常信息打印出之外，也将关键模型打印出来，方便调试
	 * 
	 * @Title: error
	 * @Description: TODO
	 * @param @param objs 异常信息，可以记录多个对象
	 * @return void
	 * @throws
	 */
	public static void error(Object... objs) {

		error(null, objs);
	}

	/**
	 * <p>
	 * 可以直接传入pojo对象，该方法会通过反射将pojo对象的结构打印出来
	 * <p>
	 * 建议调试或者异常时，除了将异常信息打印出之外，也将关键模型打印出来，方便调试
	 * 
	 * @Title: error
	 * @Description: TODO
	 * @param @param e 异常
	 * @param @param objs 异常信息，可以记录多个对象
	 * @return void
	 * @throws
	 */
	public static void error(Exception e, Object... objs) {

		Joiner joiner = Joiner.on(',');

		logger.error(joiner.join(printObjArray(objs)), e);
	}

	/**
	 * 将对象数组转化为对象结构字符串数组
	 * 
	 * @Title: printObjArray
	 * @Description: TODO
	 * @param @param objs
	 * @param @return
	 * @return String[]
	 * @throws
	 */
	private static String[] printObjArray(Object[] objs) {

		List<String> list = Lists.newArrayList();

		for (Object o : objs) {
			list.add(printObj(o));
		}

		return list.toArray(new String[0]);
	}

	/**
	 * 将对象转化为结构字符串
	 * 
	 * <li>此方法有待优化
	 * 
	 * @Title: printObj
	 * @Description: TODO
	 * @param @param obj
	 * @param @return
	 * @return String
	 * @throws
	 */
	private static String printObj(Object obj) {

		if (obj instanceof String)
			return (String) obj;

		return ReflectionToStringBuilder.toString(obj,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
