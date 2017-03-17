package com.powernode.io.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("c:\\dd.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 1; i <= 50000; i++) {
			System.out.println("i=" + i);
		}
	}
}
