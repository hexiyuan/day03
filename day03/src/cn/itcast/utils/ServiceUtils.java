package cn.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

//工具类-----将可见的密码转化成MD5码来保存

public class ServiceUtils {
	public static String md5(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(message.getBytes());
			//有可能遇到不能导入BASE64Encoder的包的问题：
			/*
			 * day03---右键---属性---buildpath---libraries---->双击一个JRE System Library[javaSE-1.6]文件
			 * ---->双击Access rules --->Add --->resolution:选择accessible/rule pattern:写入** 
			 * ---->ok--->完成
			 * */
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
}
