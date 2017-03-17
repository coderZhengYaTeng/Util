package com.powernode.io.test4;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String file =
		// "F:\\tools\\linux\\MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar";

		// String file = "c:\\aa.txt";
		// FileCopyer
		// .copyFile(
		// file,
		// "d:\\dddf\\ljd\\slfjsd\\lkjf\\dlskjf\\lkds\\jfl\\ksdj\\flkd\\sjfd\\lskj\\fdslkj\\fdsfl\\kds");

		// String file = "F:\\tools\\linux";
		// FileCopyer.copyFile(file, "d:\\");

		String path1 = "C:\\Java\\jdk1.7.0_75\\src";
		FileCopyer.copyDir(path1, "d:\\");

	}
}
