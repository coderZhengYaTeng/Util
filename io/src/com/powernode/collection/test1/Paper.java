package com.powernode.collection.test1;

import java.util.*;

/*
 Paper类   考卷类  
 属性：若干试题
 提示：试题采用HashMap存放，key为String，表示题号，value为试题对象
 */
public class Paper {
	// 存放试题的Map集合,key是题号,value是题目
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
