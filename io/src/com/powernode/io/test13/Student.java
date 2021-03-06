package com.powernode.io.test13;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 没有任何抽象方法的接口称为标识接口,是用来标识一种类型的!

public class Student implements Serializable {

	// 告诉编译器,我们这个类无论怎么变,版本号永远都是3866996697956509217L
	private static final long serialVersionUID = -3866996697956509217L;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 序列化的时候,JVM会把这个对象的所有的实例属性信息写入到文件中
	// 这就要求该类的所有的实例属性的类型都要实现Serializable接口,
	private String name;
	private Date birthday; // "1992-12-25"
	private Sex sex;// 性别
	private int score; // 考试成绩
	private String grade; // 年级
	private String addr;

	// 对于根本就无法序列化的属性,使用transient修饰符,不向文件中写入,这样避免异常的出现
	private transient Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

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
				+ ",addr=" + addr + ",obj=" + obj + "]";

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
			// 把一个已检查异常包装成一个未检查异常,通过这种方式来减轻用户的负担,用户不需要额外的处理异常
			throw new IllegalArgumentException(strbirthday + "不是有效的日期格式", e);
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
