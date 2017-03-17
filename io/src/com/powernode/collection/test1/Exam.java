package com.powernode.collection.test1;

import java.util.*;

/*
 Exam��   ������
 ���ԣ� ����ѧ��  һ�ſ���
 ��ʾ�� ѧ������HashSet��� (Student���ͱ���Ҫ����hashCode()/equals(),ʹ��name��Ϊ���ǵı�׼)

 ���⣺ΪExam�����һ������������Ϊ����ѧ���о�����ӡ�ɼ����������Ρ�������
 ������TreeSet����ѧ������
 */
public class Exam {
	private Set<Student> set; // ���ѧ����Set����
	private Paper paper; // ����

	// Ϊ��ͳ�ƿ��Գɼ���׼����TreeSet
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
	 * �����о�ķ���
	 */
	public void panJuan() {
		// �ӿ�����ȡ����������Map����,key�����,value����Ŀ
		Map<String, Question> map1 = paper.getMap();

		// �������Student��Set����,ȡ��ÿ��ѧ��,Ϊÿ��ѧ���о�
		for (Student stu : set) {
			int score = 0; // ��ʼ�����Գɼ�Ϊ0

			// ��ѧ���Ĵ����ȡ����Ŵ𰸵�Map����,key�����,value��ѧ���Ĵ�
			Map<String, String> map2 = stu.getAnswerSheet().getMap();
			// ����ѧ���𰸵�Map����,�ֱ�ȡ����ź�ѧ���Ĵ�
			Set<String> set2 = map2.keySet();
			for (String qNo : set2) {
				String answer = map2.get(qNo); // ѧ���Ĵ�

				// �Ӵ�������Map������ȡ������Ŷ�Ӧ����Ŀ
				Question ques = map1.get(qNo);

				// �ж�ѧ���Ĵ𰸺���Ŀ����ȷ���Ƿ�һ��
				if (ques.getRightAnswer().equals(answer)) {
					score += ques.getMark(); // �ѱ���ķ����ۼƸ�ѧ��
				}
			}

			// �ѳɼ����ø�ѧ��
			stu.setScore(score);

			// ���к÷�����ѧ����ӵ�TreeSet��,������TreeSet��ѧ������
			treeSet.add(stu);
		}
	}

	/**
	 * ��ӡ���Գɼ�
	 */
	public void printScore() {
		int mingCi = 1;
		for (Student stu : treeSet) {
			// ����ĸ�ʽ:��1��:��1 ; �ɼ�:98
			System.out.println("��" + mingCi + "��:" + stu);
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
