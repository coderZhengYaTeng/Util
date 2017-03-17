package com.powernode.io.test14;

import java.util.*;

// Dao:Data Access File(数据访问对象),专门来封装对数据增删改查的类 

public class StudentDao {
	/**
	 * 添加单个学生
	 * 
	 * @param stu
	 */
	public void addStudent(Student stu) {

	}

	/**
	 * 添加多个学生
	 * 
	 * @param list
	 */
	public void addStudents(List<Student> list) {

	}

	/**
	 * 通过id来删除学生
	 * 
	 * @param id
	 */
	public void removeById(int id) {

	}

	/**
	 * 修改学生的信息(注意,学号是不能修改的)
	 * 
	 * @param newStudent
	 */
	public void updateStudent(Student newStudent) {

	}

	/**
	 * 查询所有学生的信息
	 * 
	 * @return
	 */
	public Set<Student> selectAll() {
		return null;
	}

	/**
	 * 根据学号查询学生信息
	 * 
	 * @param id
	 * @return
	 */
	public Student selectStudentById(int id) {
		return null;
	}

	public List<Student> selectStudentsByName(String name) {
		return null;
	}
}
