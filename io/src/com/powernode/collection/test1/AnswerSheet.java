package com.powernode.collection.test1;

import java.util.*;

/*
 AnswerSheet��    �����
 ���ԣ�ÿ����Ĵ�    
 ��ʾ�������ÿ����Ĵ���HashMap��ţ�keyΪString����ʾ��ţ�valueΪѧ���Ĵ�
 */
public class AnswerSheet {
	// ���ѧ���𰸵�Map����,key�����,value��ѧ���Ĵ�
	private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public AnswerSheet() {
		super();
	}

	public AnswerSheet(Map<String, String> map) {
		super();
		this.map = map;
	}

}
