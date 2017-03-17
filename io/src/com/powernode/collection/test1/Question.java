package com.powernode.collection.test1;

import java.util.*;

public class Question {
	private int qNo; // ���
	private String qDes; // ��Ŀ����
	private List<String> list; // ����ѡ��
	private String rightAnswer; // ��ȷ��
	private int mark; // ����Ŀ�ķ���

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqDes() {
		return qDes;
	}

	public void setqDes(String qDes) {
		this.qDes = qDes;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Question() {
		super();
	}

	public Question(int qNo, String qDes, List<String> list,
			String rightAnswer, int mark) {
		super();
		this.qNo = qNo;
		this.qDes = qDes;
		this.list = list;
		this.rightAnswer = rightAnswer;
		this.mark = mark;
	}

}
