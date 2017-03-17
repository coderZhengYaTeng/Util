package com.powernode.collection.test1;

import java.util.Comparator;

// ��ѧ������ıȽ���,�ȽϹ�������:
// 1.���տ��Գɼ���������
// 2.�ɼ���ͬ,����name����

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getScore() > o2.getScore()){
			return -1;
		}
		
		if(o1.getScore() < o2.getScore()){
			return 1;
		}
		
		
		return (o1.getName().compareTo(o2.getName()));
	}

}
