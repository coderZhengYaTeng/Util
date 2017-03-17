package com.powernode.collection.test1;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ���ѡ��
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");

		// ����10������
		Question q1 = new Question(1, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q2 = new Question(2, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q3 = new Question(3, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q4 = new Question(4, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q5 = new Question(5, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q6 = new Question(6, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q7 = new Question(7, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q8 = new Question(8, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q9 = new Question(9, "Java�еĻ������������м��֣�", list1, "8", 10);
		Question q10 = new Question(10, "Java�еĻ������������м��֣�", list1, "8", 10);

		// ����ѧ��1���
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("��1��:", "8");
		map1.put("��2��:", "8");
		map1.put("��3��:", "8");
		map1.put("��4��:", "8");
		map1.put("��5��:", "8");
		map1.put("��6��:", "8");
		map1.put("��7��:", "8");
		map1.put("��8��:", "8");
		map1.put("��9��:", "8");
		map1.put("��10��:", "8");
		AnswerSheet answer1 = new AnswerSheet(map1);

		// ����ѧ��2���
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("��1��:", "8");
		map2.put("��2��:", "8");
		map2.put("��3��:", "6");
		map2.put("��4��:", "3");
		map2.put("��5��:", "4");
		map2.put("��6��:", "8");
		map2.put("��7��:", "1");
		map2.put("��8��:", "7");
		map2.put("��9��:", "8");
		map2.put("��10��:", "8");
		AnswerSheet answer2 = new AnswerSheet(map2);

		// ����ѧ��3���
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("��1��:", "8");
		map3.put("��2��:", "8");
		map3.put("��3��:", "8");
		map3.put("��4��:", "8");
		map3.put("��5��:", "9");
		map3.put("��6��:", "8");
		map3.put("��7��:", "8");
		map3.put("��8��:", "8");
		map3.put("��9��:", "8");
		map3.put("��10��:", "7");
		AnswerSheet answer3 = new AnswerSheet(map3);

		// ����һ���Ծ�
		HashMap<String, Question> map = new HashMap<String, Question>();
		map.put("��1��:", q1);
		map.put("��2��:", q2);
		map.put("��3��:", q3);
		map.put("��4��:", q4);
		map.put("��5��:", q5);
		map.put("��6��:", q6);
		map.put("��7��:", q7);
		map.put("��8��:", q8);
		map.put("��9��:", q9);
		map.put("��10��:", q10);
		Paper paper = new Paper(map);

		HashSet<Student> set = new HashSet<Student>();
		// ����4��ѧ�� ����ӵ�Set��
		Student s1 = new Student("ѧ��1 ", answer1, paper);
		Student s2 = new Student("ѧ��2 ", answer2, paper);
		Student s3 = new Student("ѧ��3 ", answer3, paper);
		Student s4 = new Student("ѧ��4 ", answer3, paper);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);

		// =================== ����һ������==========================
		Exam exam = new Exam(set, paper);
		exam.panJuan();
		exam.printScore();
	}

}
