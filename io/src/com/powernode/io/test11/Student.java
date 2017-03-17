package com.powernode.io.test11;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// û���κγ��󷽷��Ľӿڳ�Ϊ��ʶ�ӿ�,��������ʶһ�����͵�!

public class Student implements Serializable {

	// ���߱�����,���������������ô��,�汾����Զ����3866996697956509217L
	private static final long serialVersionUID = -3866996697956509217L;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// ���л���ʱ��,JVM��������������е�ʵ��������Ϣд�뵽�ļ���
	// ���Ҫ���������е�ʵ�����Ե����Ͷ�Ҫʵ��Serializable�ӿ�,����Ҫ��AddressҲʵ��Serializable�ӿ�
	private String name;
	private Date birthday; // "1992-12-25"
	private Sex sex;// �Ա�
	private int score; // ���Գɼ�
	private String grade; // �꼶

	private String addr; // ��Ҫ����������

	// ///////////////////////////////////////////////////////////////////////////////////
	// ObjectOutputStream���������������main�����д�������
	// JVM����������ݸ�Student����,�ö����Լ��ڰ�ʵ�����Ե���Ϣд���ļ���
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeInt(this.score);
		out.writeObject(name);
		out.writeObject(this.birthday);
		out.writeObject(this.sex);
		out.writeObject(this.grade);

		// ��addr���м��ܴ���,Ȼ�󽫼��ܺ������д���ļ���
		addr = this.encode(addr);
		out.writeObject(addr);
	}

	// ObjectInputStream���������������main�����д�������
	// JVM����������ݸ�Student����,�ö����Լ��ڶ�ȡ�������Ϣ
	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		// ע���ڶ�ȡ��ʱ�����Ҫ����д��ʱ���˳���ȡ
		score = in.readInt();
		name = (String) in.readObject();
		this.birthday = (Date) in.readObject();
		sex = (Sex) in.readObject();
		grade = (String) in.readObject();

		// ��ȡ������addr�Ǽ��ܹ���,��addr���н���
		addr = (String) in.readObject();
		addr = this.decode(addr);
	}

	// �����㷨(��GBK-> ISO-8859-1)
	private String encode(String str) {
		String temp = null;
		try {
			temp = new String(str.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	// �����㷨(��ISO-8859-1-> GBK)
	private String decode(String str) {
		String temp = null;
		try {
			temp = new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	// ///////////////////////////////////////////////////////////////////////////////////

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", birthday=" + formatDate(birthday)
				+ ",sex=" + sex + ",score=" + this.score + ",grade=" + grade
				+ ",addr=" + addr + "]";

	}

	private String formatDate(Date date) {
		return sdf.format(date);
	}

	public Student() {
		super();
	}

	public Student(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public Student(String name, String strbirthday) {
		super();
		this.name = name;
		try {
			this.birthday = sdf.parse(strbirthday);
		} catch (ParseException e) {
			// ��һ���Ѽ���쳣��װ��һ��δ����쳣,ͨ�����ַ�ʽ�������û��ĸ���,�û�����Ҫ����Ĵ����쳣
			throw new IllegalArgumentException(strbirthday + "������Ч�����ڸ�ʽ", e);
		}
	}

	public Student(String name, String strbirthday, Sex sex, int score,
			String grade) {
		this(name, strbirthday);
		this.sex = sex;
		this.score = score;
		this.grade = grade;
	}
}
