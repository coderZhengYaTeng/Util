package com.powernode.io.test1;

import java.io.*;

public class ByteStreamTest {

	public static void readFile1() {
		FileInputStream fin = null;
		try {
			// �ļ�����Ϣ�����������:·������ + �ָ��� + �ļ�����
			fin = new FileInputStream("c:\\aa.txt");

			int i = 0;
			// ��ȡһ���ֽ�,����int����,�ж�intֵ�Ƿ����-1
			while ((i = fin.read()) != -1) {
				// byte -> int -> char
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readFile2() {
		FileInputStream fin = null;
		try {
			// �ļ�����Ϣ�����������:·������ + �ָ��� + �ļ�����
			fin = new FileInputStream("c:\\aa.txt");

			int i = 0;
			byte[] b = new byte[200];

			// i��ʾ��ȡ�����ֽڵ�����
			while ((i = fin.read(b)) != -1) {
				// byte [] -> String
				String str = new String(b, 0, i);
				System.out.print(str); // �����ʱ��str���Ѿ������˻���,�Ͳ�Ҫ�����Լ���������
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeFile1() {
		FileOutputStream fout = null;

		try {
			// ��Ŀ���ļ������ڵ�ʱ��,JVM�ᴴ������ļ�
			// ��Ŀ���ļ��Ѿ����ڵ�ʱ��,JVM�������д������ļ���
			fout = new FileOutputStream("c:\\dd.txt", true);

			for (int i = 1; i <= 100000; i++) {
				String str = i
						+ ".��Ҫ���� OutputStream �����Ӧ�ó������ʼ���ṩ����һ�ֿ�д��һ������ֽڵķ���\r\n";
				// String -> byte[]
				byte[] b = str.getBytes();
				fout.write(b);
			}

			System.out.println("�ļ�д��ɹ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fout != null) {
					fout.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void writeFile2() {
		FileOutputStream fout = null;
		PrintStream ps = null;

		try {
			// ����ļ���ʱ��,��û��ָ��·�����Ƶ�ʱ��,�ļ�Ĭ�ϵ������Eclipse��Ŀ��
			fout = new FileOutputStream("dd.txt", true);
			ps = new PrintStream(fout);

			for (int i = 1; i <= 10000; i++) {
				String str = i
						+ ".��Ҫ���� OutputStream �����Ӧ�ó������ʼ���ṩ����һ�ֿ�д��һ������ֽڵķ���.";
				ps.println(str);
			}

			System.out.println("�ļ�д��ɹ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Ϊ�˱��ڲ���,ps�رյ�ʱ����Ҫ�����쳣
			if (ps != null) {
				ps.close();
			}
		}
	}

	/**
	 * �����ļ��Ĳ���
	 * 
	 * @param srcFile
	 *            Դ�ļ�
	 * @param desPath
	 *            Ŀ��·��
	 */
	public static void copy(String srcFile, String desPath) {
		// ��Դ�ļ��л�ȡ�ļ���,
		// �����"F:\\tools\\linux\\MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar"�л�ȡ��MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar
		String[] arr = srcFile.split("\\\\"); // �����ļ��ָ������з�String
		String fileName = arr[arr.length - 1];

		// ��֯Ŀ���ļ�
		String desFile = desPath + "\\" + fileName;

		FileInputStream fin = null;
		FileOutputStream fout = null;

		try {
			fin = new FileInputStream(srcFile);
			fout = new FileOutputStream(desFile);

			byte[] b = new byte[1024 * 1024]; // ������1M���ڴ�
			int i = 0;
			while ((i = fin.read(b)) != -1) {
				fout.write(b, 0, i);
			}

			System.out.println(srcFile + "������" + desFile + "���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fout != null) {
					fout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// readFile1();
		// readFile2();
		// writeFile1();

		// String file =
		// "F:\\tools\\linux\\MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar";
		// copy(file, "d:\\");

		writeFile2();
	}
}
