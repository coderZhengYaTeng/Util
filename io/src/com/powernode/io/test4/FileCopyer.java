package com.powernode.io.test4;

import java.io.*;

public class FileCopyer {

	private FileCopyer() {
	}

	/**
	 * �����ļ��Ĺ���
	 * 
	 * @param srcFile
	 *            Դ�ļ�
	 * @param desPath
	 *            Ŀ��·��
	 */
	public static void copyFile(String srcFile, String desPath) {
		// String -> File
		copyFile(new File(srcFile), desPath);
	}

	/**
	 * �����ļ��Ĺ���
	 * 
	 * @param srcFile
	 *            Դ�ļ�
	 * @param desPath
	 *            Ŀ��·��
	 */
	public static void copyFile(File srcFile, String desPath) {
		// ȡ���ļ���
		String fileName = srcFile.getName();

		// �ж�Ŀ��·���Ƿ����,����������򴴽�Ŀ��·��
		File path1 = new File(desPath);
		if (!path1.exists()) {
			System.out.println("����Ŀ¼�Ƿ�ɹ�:" + path1.mkdirs());
		}

		// ��֯Ŀ���ļ�
		String desFile = desPath + File.separator + fileName;

		// �����ͼ���
		FileInputStream fin = null;
		FileOutputStream fout = null;

		// �����߼���
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		try {
			// ���ȳ�ʼ���ͼ���
			// FileInputStream/FileOutputStreamֻ�ܶ�д�ļ�,�����ܶ�дĿ¼
			fin = new FileInputStream(srcFile); //
			fout = new FileOutputStream(desFile);

			// ���ʼ���߼���
			bin = new BufferedInputStream(fin);
			bout = new BufferedOutputStream(fout);

			int i = 0;
			byte[] b = new byte[1024 * 1024];

			while ((i = bin.read(b)) != -1) {
				bout.write(b, 0, i);
			}
			// bout.flush();

			System.out.println(srcFile.toString() + "������" + desFile + "���");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ////////////////////////////////////////////////////////////////
			// ����Ĺرշ�ʽ:�رյͼ���
			// try {
			// if (fin != null) {
			// fin.close();
			// }
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			//
			// try {
			// if (fout != null) {
			// fout.close();
			// }
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

			// ////////////////////////////////////////////////////////////////
			// ��ȷ�Ĺرշ�ʽ:�رո߼���
			try {
				if (bin != null) {
					bin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (bout != null) {
					// �رո߼�����ʱ��߼��������е����ݻᱻ�Զ���ˢ��
					bout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����Ŀ¼�Ĺ���
	 * 
	 * @param srcPath
	 *            ԴĿ¼
	 * @param desPath
	 *            Ŀ��·��
	 */
	public static void copyDir(String srcPath, String desPath) {
		copyDir(new File(srcPath), desPath);
	}

	/**
	 * ����Ŀ¼�Ĺ���
	 * 
	 * @param srcPath
	 *            ԴĿ¼
	 * @param desPath
	 *            Ŀ��·��
	 */
	public static void copyDir(File srcPath, String desPath) {
		// �ж�srcPath���ļ�����·��
		if (srcPath.isFile()) { // �ļ�
			copyFile(srcPath, desPath); // ֱ�ӵ��ÿ����ļ��ķ���
		} else {// ·��
			// ��ԴĿ¼�л�ȡҪ������·�������,Ҳ���Ǵ�"C:\\Java\\jdk1.7.0_75\\src"���л�ȡ��src
			String pathName = srcPath.getName();

			// ��Ŀ��·���д���Ҫ������·��,����:��d:\\ ����srcĿ¼
			String dPath = desPath + File.separator + pathName;
			File path1 = new File(dPath);
			path1.mkdirs();

			// ��ȡԴĿ¼�����е����ļ�
			File[] files = srcPath.listFiles();

			// ��������,һ��һ���Ŀ���
			for (File file : files) {
				// ֱ�ӵݹ����
				copyDir(file, dPath);
			}
		}
	}
}
