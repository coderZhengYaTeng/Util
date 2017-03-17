package com.powernode.io.test13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.FileOutputStream;

// ע��:���ķ����в�û�ж��������ַַ�,ObjectStreamTest�����Ǹ���������

public class ObjectStreamTest {

	private static String file = "stu.dat";

	public static void writeObjectToFile() {
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;

		try {
			fout = new FileOutputStream(file);
			oout = new ObjectOutputStream(fout);

			Student stu = new Student("��1111", "1992-12-8", Sex.��, 90,
					"Java��ҵ��-671");
			stu.setAddr("�����д�������ׯ���ÿ�������ˮ�Ӷ��ִ�����ҵ��");
			stu.setObj(new Object());

			oout.writeObject(stu);
			System.out.println("����д���ļ��ɹ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oout != null) {
					oout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ���ļ��л������ȡ����,��Ϊ�����л�;��ν�ķ����л���ʵ���Ǵ��ļ��л������ж�ȡ���������Ϣ,Ȼ�������Щ�����´�����һ���µĶ���(Ҳ���ǿ�¡��һ��)
	public static void readObjectFromFile() {
		FileInputStream fin = null;
		ObjectInputStream oin = null;

		try {
			fin = new FileInputStream(file);
			oin = new ObjectInputStream(fin);

			Object obj = oin.readObject(); // "��1111", "1992-12-8", Sex.��, 90
			System.out.println(obj);
			// System.out.println(obj + ",stu.hashCode()=" + obj.hashCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oin != null) {
					oin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// writeObjectToFile();
		readObjectFromFile();
	}

}
