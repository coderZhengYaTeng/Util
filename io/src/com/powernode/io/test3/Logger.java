package com.powernode.io.test3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static String file = "log.dat";
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SSS");

	private Logger() {

	}

	/**
	 * ��¼String��Ϣ����־�ļ�
	 * 
	 * @param msg
	 */
	public static void log(String msg) {
		FileOutputStream fout = null;
		PrintStream ps = null;

		try {
			fout = new FileOutputStream(file, true);
			ps = new PrintStream(fout);

			String time = getTime();
		    ps.println(time);
			ps.println(msg);
			ps.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	private static String getTime() {
		Date date = new Date();
		return sdf.format(date);
	}

	/**
	 * ��¼�쳣��Ϣ����־�ļ�
	 * 
	 * @param msg
	 */
	public static void log(Exception ex) {
		FileOutputStream fout = null;
		PrintStream ps = null;

		try {
			fout = new FileOutputStream(file, true);
			ps = new PrintStream(fout);

			String time = getTime();
			ps.println(time);
			ex.printStackTrace(ps); // ���쳣��Ϣ��¼��PS��
			ps.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}
}
