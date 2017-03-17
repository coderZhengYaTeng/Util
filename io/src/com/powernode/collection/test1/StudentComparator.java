package com.powernode.collection.test1;

import java.util.Comparator;

// 给学生排序的比较器,比较规则如下:
// 1.按照考试成绩降序排列
// 2.成绩相同,按照name排序

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
