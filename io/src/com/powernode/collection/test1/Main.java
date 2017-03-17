package com.powernode.collection.test1;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 添加选项
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");

		// 创建10道试题
		Question q1 = new Question(1, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q2 = new Question(2, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q3 = new Question(3, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q4 = new Question(4, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q5 = new Question(5, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q6 = new Question(6, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q7 = new Question(7, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q8 = new Question(8, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q9 = new Question(9, "Java中的基本数据类型有几种？", list1, "8", 10);
		Question q10 = new Question(10, "Java中的基本数据类型有几种？", list1, "8", 10);

		// 创建学生1答卷
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("第1题:", "8");
		map1.put("第2题:", "8");
		map1.put("第3题:", "8");
		map1.put("第4题:", "8");
		map1.put("第5题:", "8");
		map1.put("第6题:", "8");
		map1.put("第7题:", "8");
		map1.put("第8题:", "8");
		map1.put("第9题:", "8");
		map1.put("第10题:", "8");
		AnswerSheet answer1 = new AnswerSheet(map1);

		// 创建学生2答卷
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("第1题:", "8");
		map2.put("第2题:", "8");
		map2.put("第3题:", "6");
		map2.put("第4题:", "3");
		map2.put("第5题:", "4");
		map2.put("第6题:", "8");
		map2.put("第7题:", "1");
		map2.put("第8题:", "7");
		map2.put("第9题:", "8");
		map2.put("第10题:", "8");
		AnswerSheet answer2 = new AnswerSheet(map2);

		// 创建学生3答卷
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("第1题:", "8");
		map3.put("第2题:", "8");
		map3.put("第3题:", "8");
		map3.put("第4题:", "8");
		map3.put("第5题:", "9");
		map3.put("第6题:", "8");
		map3.put("第7题:", "8");
		map3.put("第8题:", "8");
		map3.put("第9题:", "8");
		map3.put("第10题:", "7");
		AnswerSheet answer3 = new AnswerSheet(map3);

		// 创建一套试卷
		HashMap<String, Question> map = new HashMap<String, Question>();
		map.put("第1题:", q1);
		map.put("第2题:", q2);
		map.put("第3题:", q3);
		map.put("第4题:", q4);
		map.put("第5题:", q5);
		map.put("第6题:", q6);
		map.put("第7题:", q7);
		map.put("第8题:", q8);
		map.put("第9题:", q9);
		map.put("第10题:", q10);
		Paper paper = new Paper(map);

		HashSet<Student> set = new HashSet<Student>();
		// 创建4个学生 并添加到Set中
		Student s1 = new Student("学生1 ", answer1, paper);
		Student s2 = new Student("学生2 ", answer2, paper);
		Student s3 = new Student("学生3 ", answer3, paper);
		Student s4 = new Student("学生4 ", answer3, paper);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);

		// =================== 创建一个考试==========================
		Exam exam = new Exam(set, paper);
		exam.panJuan();
		exam.printScore();
	}

}
