package com.powernode.io.test8;

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

	// �Ѷ���д�뵽�ļ��л�������,��Ϊ���л�.��ν�����л���ʵ���ǽ��������Ϣд�뵽�ļ���
	// ���������������Ϣ,�����ʵ�����Ե���Ϣ�ᱻд�뵽�ļ���
	// ������ķ�����Ϣ,���췽����Ϣ,��̬������Ϣ,�ֲ�������Ϣ�ǲ��ᱻд���ļ��е�
	public static void writeObjectToFile() {
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;

		try {
			fout = new FileOutputStream(file);
			oout = new ObjectOutputStream(fout);

			Student stu = new Student("��1111", "1992-12-8", Sex.��, 90);
			oout.writeObject(stu);
			System.out.println("����д���ļ��ɹ�");
			// System.out.println("����д���ļ��ɹ�,stu.hashCode()=" + stu.hashCode());
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
		writeObjectToFile();
		readObjectFromFile();
	}

}
