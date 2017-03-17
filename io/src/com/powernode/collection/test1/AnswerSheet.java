package com.powernode.collection.test1;

import java.util.*;

/*
 AnswerSheet类    答卷类
 属性：每道题的答案    
 提示：答卷中每道题的答案用HashMap存放，key为String，表示题号，value为学生的答案
 */
public class AnswerSheet {
	// 存放学生答案的Map集合,key是题号,value是学生的答案
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
