package com.powernode.io.test1;

import java.io.*;

public class ByteStreamTest {

	public static void readFile1() {
		FileInputStream fin = null;
		try {
			// 文件的信息有三部分组成:路径名称 + 分隔符 + 文件名称
			fin = new FileInputStream("c:\\aa.txt");

			int i = 0;
			// 读取一个字节,当做int返回,判断int值是否等于-1
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
			// 文件的信息有三部分组成:路径名称 + 分隔符 + 文件名称
			fin = new FileInputStream("c:\\aa.txt");

			int i = 0;
			byte[] b = new byte[200];

			// i表示读取到的字节的数量
			while ((i = fin.read(b)) != -1) {
				// byte [] -> String
				String str = new String(b, 0, i);
				System.out.print(str); // 输出的时候str中已经包含了换行,就不要我们自己处理换行了
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
			// 当目标文件不存在的时候,JVM会创建这个文件
			// 当目标文件已经存在的时候,JVM会把数据写到这个文件中
			fout = new FileOutputStream("c:\\dd.txt", true);

			for (int i = 1; i <= 100000; i++) {
				String str = i
						+ ".需要定义 OutputStream 子类的应用程序必须始终提供至少一种可写入一个输出字节的方法\r\n";
				// String -> byte[]
				byte[] b = str.getBytes();
				fout.write(b);
			}

			System.out.println("文件写入成功");
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
			// 输出文件的时候,当没有指定路径名称的时候,文件默认的输出到Eclipse项目中
			fout = new FileOutputStream("dd.txt", true);
			ps = new PrintStream(fout);

			for (int i = 1; i <= 10000; i++) {
				String str = i
						+ ".需要定义 OutputStream 子类的应用程序必须始终提供至少一种可写入一个输出字节的方法.";
				ps.println(str);
			}

			System.out.println("文件写入成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 为了便于操作,ps关闭的时候不需要处理异常
			if (ps != null) {
				ps.close();
			}
		}
	}

	/**
	 * 拷贝文件的操作
	 * 
	 * @param srcFile
	 *            源文件
	 * @param desPath
	 *            目标路径
	 */
	public static void copy(String srcFile, String desPath) {
		// 从源文件中获取文件名,
		// 例如从"F:\\tools\\linux\\MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar"中获取到MySQL-5.6.16-1.rhel5.i386.rpm-bundle.tar
		String[] arr = srcFile.split("\\\\"); // 按照文件分隔符来切分String
		String fileName = arr[arr.length - 1];

		// 组织目标文件
		String desFile = desPath + "\\" + fileName;

		FileInputStream fin = null;
		FileOutputStream fout = null;

		try {
			fin = new FileInputStream(srcFile);
			fout = new FileOutputStream(desFile);

			byte[] b = new byte[1024 * 1024]; // 创建了1M的内存
			int i = 0;
			while ((i = fin.read(b)) != -1) {
				fout.write(b, 0, i);
			}

			System.out.println(srcFile + "拷贝到" + desFile + "完成");
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
