package com.powernode.io.test3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Logger.log("����ʼִ����");
		for (int i = 1; i <= 1000; i++) {
			try {
				FileInputStream fin = new FileInputStream("c:\\dd.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace(); // ���쳣��Ϣ��¼������̨
				Logger.log(e); // ���쳣��Ϣ��¼����־�ļ�
			}
		}
		Logger.log("����ִ�н���");

	}

}
