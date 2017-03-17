package com.powernode.collection.test1;

/*
 Student类     学生类
 属性：姓名   一张答卷   一张考卷  ,学生的考试成绩
 */
public class Student {
	private String name; // 名字
	private AnswerSheet answerSheet; // 学生的答卷
	private Paper paper; // 考卷
	private int score; // 考试成绩

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnswerSheet getAnswerSheet() {
		return answerSheet;
	}

	public void setAnswerSheet(AnswerSheet answerSheetp) {
		this.answerSheet = answerSheetp;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	// //////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		// 张1 ; 成绩:98
		return name + " ; 成绩:" + this.score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Student) {
			Student stu = (Student) obj;
			if (this.name.equals(stu.name)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() * 31;
	}

	// //////////////////////////////////////////////////////////////////

	public Student() {
		super();
	}

	public Student(String name, AnswerSheet answerSheetp, Paper paper) {
		super();
		this.name = name;
		this.answerSheet = answerSheetp;
		this.paper = paper;
	}

}
