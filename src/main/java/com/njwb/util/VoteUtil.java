package com.njwb.util;
/*
 * 判空
 * */
public class VoteUtil {
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str.trim()) ? true : false;
	}
}
