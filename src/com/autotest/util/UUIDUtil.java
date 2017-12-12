package com.autotest.util;

import java.util.UUID;

/**
 * UUID生成工具类
 * @author Administrator
 *
 */
public class UUIDUtil {
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String temp = uuid.toString();
		String result = temp.substring(0, 8) + temp.substring(9, 13) + temp.substring(14, 18) + temp.substring(19, 23) + temp.substring(24);
		return result;
	}
}
