package com.powernode.collection.test1;

/*
 Student��     ѧ����
 ���ԣ�����   һ�Ŵ��   һ�ſ���  ,ѧ���Ŀ��Գɼ�
 */
public class Student {
	private String name; // ����
	private AnswerSheet answerSheet; // ѧ���Ĵ��
	private Paper paper; // ����
	private int score; // ���Գɼ�

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
		// ��1 ; �ɼ�:98
		return name + " ; �ɼ�:" + this.score;
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
