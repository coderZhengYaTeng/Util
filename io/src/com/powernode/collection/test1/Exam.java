package com.powernode.collection.test1;

import java.util.*;

/*
 Exam类   考试类
 属性： 若干学生  一张考卷
 提示： 学生采用HashSet存放 (Student类型必须要覆盖hashCode()/equals(),使用name作为覆盖的标准)

 问题：为Exam类添加一个方法，用来为所有学生判卷，并打印成绩排名（名次、姓名）
 借助于TreeSet来给学生排序
 */
public class Exam {
	private Set<Student> set; // 存放学生的Set集合
	private Paper paper; // 考卷

	// 为了统计考试成绩而准备的TreeSet
	private TreeSet<Student> treeSet = new TreeSet<Student>(
			new StudentComparator());

	public Set<Student> getSet() {
		return set;
	}

	public void setSet(Set<Student> set) {
		this.set = set;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	/**
	 * 考试判卷的方法
	 */
	public void panJuan() {
		// 从考卷中取出存放试题的Map集合,key是题号,value是题目
		Map<String, Question> map1 = paper.getMap();

		// 遍历存放Student的Set集合,取出每个学生,为每个学生判卷
		for (Student stu : set) {
			int score = 0; // 初始化考试成绩为0

			// 从学生的答卷中取出存放答案的Map集合,key是题号,value是学生的答案
			Map<String, String> map2 = stu.getAnswerSheet().getMap();
			// 变量学生答案的Map集合,分别取出题号和学生的答案
			Set<String> set2 = map2.keySet();
			for (String qNo : set2) {
				String answer = map2.get(qNo); // 学生的答案

				// 从存放试题的Map集合中取出该题号对应的题目
				Question ques = map1.get(qNo);

				// 判断学生的答案和题目的正确答案是否一致
				if (ques.getRightAnswer().equals(answer)) {
					score += ques.getMark(); // 把本题的分数累计给学生
				}
			}

			// 把成绩设置给学生
			stu.setScore(score);

			// 把判好分数的学生添加到TreeSet中,借助于TreeSet给学生排序
			treeSet.add(stu);
		}
	}

	/**
	 * 打印考试成绩
	 */
	public void printScore() {
		int mingCi = 1;
		for (Student stu : treeSet) {
			// 输出的格式:第1名:张1 ; 成绩:98
			System.out.println("第" + mingCi + "名:" + stu);
			mingCi++;
		}
	}

	public Exam() {
		super();
	}

	public Exam(Set<Student> set, Paper paper) {
		super();
		this.set = set;
		this.paper = paper;
	}

}
