package com.powernode.io.test7;

import java.io.File;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String file = "F:\\tools\\linux\\MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar";
		FileCopyer fc = new FileCopyer(new File("D:\\动力节点\\软件\\staruml5.zip"),"e:\\",5);
		fc.start();
	}
}
