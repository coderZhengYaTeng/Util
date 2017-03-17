package com.powernode.io.test6;

import java.io.*;

// ������:��ν��б����ʽ��ת��

public class RandomAccessFileTest {
	public static void writeFile() {
		RandomAccessFile rout = null;
		try {
			rout = new RandomAccessFile("cc.txt", "rw");
			rout.seek(rout.length()); // ����д���λ��

			for (int i = 1; i <= 100; i++) {

				String str = i
						+ ".��ֻ����ʽ�򿪡����ý��������κ� write �������������׳� IOException\r\n";

				// RandomAccessFile��֧��GBK�����ʽ,����֧��ISO-8859-1��ʽ���ַ�����
				// ������Ҫ��GBK��ʽ��Stringת��ΪISO-8859-1��ʽ��String
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
				// RandomAccessFile��ȡ������String��ISO-8859-1��ʽ��
				// ����Ҫ��ISO-8859-1��ʽת��ΪGBK��ʽ
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
