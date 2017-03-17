package com.powernode.io.test8;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// û���κγ��󷽷��Ľӿڳ�Ϊ��ʶ�ӿ�,��������ʶһ�����͵�!

public class Student  implements Serializable{
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String name;
	private Date birthday; // "1992-12-25"
	private Sex sex;// �Ա�
	private int score; // ���Գɼ�

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
				+ ",sex=" + sex + ",score=" + this.score + "]";
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

	public Student(String name, String strbirthday, Sex sex, int score) {
		this(name, strbirthday);
		this.sex = sex;
		this.score = score;
		String addr = "����";
	}
}
