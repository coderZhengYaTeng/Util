package com.powernode.io.test8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.FileOutputStream;

// 注意:流的分类中并没有对象流这种分法,ObjectStreamTest仅仅是个类名而已

public class ObjectStreamTest {

	private static String file = "stu.dat";

	// 把对象写入到文件中或网络中,称为序列化.所谓的序列化的实质是将对象的信息写入到文件中
	// 对象的完整类名信息,对象的实例属性的信息会被写入到文件中
	// 而对象的方法信息,构造方法信息,静态变量信息,局部变量信息是不会被写到文件中的
	public static void writeObjectToFile() {
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;

		try {
			fout = new FileOutputStream(file);
			oout = new ObjectOutputStream(fout);

			Student stu = new Student("张1111", "1992-12-8", Sex.男, 90);
			oout.writeObject(stu);
			System.out.println("对象写入文件成功");
			// System.out.println("对象写入文件成功,stu.hashCode()=" + stu.hashCode());
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

	// 从文件中或网络读取对象,称为反序列化;所谓的反序列化的实质是从文件中或网络中读取出对象的信息,然后根据这些新重新创建了一个新的对象(也就是克隆了一份)
	public static void readObjectFromFile() {
		FileInputStream fin = null;
		ObjectInputStream oin = null;

		try {
			fin = new FileInputStream(file);
			oin = new ObjectInputStream(fin);

			Object obj = oin.readObject(); // "张1111", "1992-12-8", Sex.男, 90
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
