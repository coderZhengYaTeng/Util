package com.powernode.io.test6;

import java.io.*;

// 面试题:如何进行编码格式的转换

public class RandomAccessFileTest {
	public static void writeFile() {
		RandomAccessFile rout = null;
		try {
			rout = new RandomAccessFile("cc.txt", "rw");
			rout.seek(rout.length()); // 设置写入的位置

			for (int i = 1; i <= 100; i++) {

				String str = i
						+ ".以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException\r\n";

				// RandomAccessFile不支持GBK编码格式,而是支持ISO-8859-1格式的字符编码
				// 我们需要把GBK格式的String转换为ISO-8859-1格式的String
				String temp = new String(str.getBytes("GBK"), "ISO-8859-1");

				rout.writeBytes(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rout != null) {
					rout.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void readFile() {
		RandomAccessFile rin = null;

		try {
			rin = new RandomAccessFile("cc.txt", "r");

			String str = null;
			while ((str = rin.readLine()) != null) {
				// RandomAccessFile读取出来的String是ISO-8859-1格式的
				// 我们要把ISO-8859-1格式转换为GBK格式
				String temp = new String(str.getBytes("ISO-8859-1"), "GBK");
				System.out.println(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rin != null) {
					rin.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// writeFile();
		readFile();
	}

}
