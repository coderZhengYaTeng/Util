package com.powernode.collection.test1;

import java.util.*;

/*
 Paper��   ������  
 ���ԣ���������
 ��ʾ���������HashMap��ţ�keyΪString����ʾ��ţ�valueΪ�������
 */
public class Paper {
	// ��������Map����,key�����,value����Ŀ
	private Map<String, Question> map;

	public Map<String, Question> getMap() {
		return map;
	}

	public void setMap(Map<String, Question> map) {
		this.map = map;
	}

	public Paper() {
		super();
	}

	public Paper(Map<String, Question> map) {
		super();
		this.map = map;
	}

}
