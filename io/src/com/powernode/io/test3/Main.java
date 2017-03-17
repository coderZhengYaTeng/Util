package com.powernode.io.test3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Logger.log("程序开始执行了");
		for (int i = 1; i <= 1000; i++) {
			try {
				FileInputStream fin = new FileInputStream("c:\\dd.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace(); // 把异常信息记录到控制台
				Logger.log(e); // 把异常信息记录到日志文件
			}
		}
		Logger.log("程序执行结束");

	}

}
