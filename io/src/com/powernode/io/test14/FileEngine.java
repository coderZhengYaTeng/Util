package com.powernode.io.test14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

// 完成序列化/反序列化操作的类

public class FileEngine {
	private static String file = "stus.dat";

	private FileEngine() {

	}

	/**
	 * 把保存学生信息的Set集合序列化到文件中
	 * 
	 * @param set
	 */
	public static void writeSetToFile(Set<Student> set) {
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;

		try {
			fout = new FileOutputStream(file);
			oout = new ObjectOutputStream(fout);

			oout.writeObject(set);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (oout != null) {
					oout.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 从文件中读取保存学生信息的Set集合
	 * 
	 * @return
	 */
	public static Set<Student> readSetFromFile() {
		Set<Student> set = null;
		FileInputStream fin = null;
		ObjectInputStream oin = null;

		try {
			fin = new FileInputStream(file);
			oin = new ObjectInputStream(fin);

			set = (Set<Student>) oin.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (oin != null) {
					oin.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return set;

	}
}
