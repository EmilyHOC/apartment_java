package com.njwb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/*
 * 放入date 格式化输入
 * */
@Component
public class SimpleDateUtil{
	public static String simpleDateUtil(Date date) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(simpleDate.format(date));
		return  simpleDate.format(date);
	}
}

