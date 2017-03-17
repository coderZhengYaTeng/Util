package com.powernode.io.test14;

import java.io.Serializable;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student>, Serializable {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId() - o2.getId();
	}

}
