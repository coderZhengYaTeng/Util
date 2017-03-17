package com.powernode.io.test4;

import java.io.*;

public class FileCopyer {

	private FileCopyer() {
	}

	/**
	 * 拷贝文件的功能
	 * 
	 * @param srcFile
	 *            源文件
	 * @param desPath
	 *            目标路径
	 */
	public static void copyFile(String srcFile, String desPath) {
		// String -> File
		copyFile(new File(srcFile), desPath);
	}

	/**
	 * 拷贝文件的功能
	 * 
	 * @param srcFile
	 *            源文件
	 * @param desPath
	 *            目标路径
	 */
	public static void copyFile(File srcFile, String desPath) {
		// 取得文件名
		String fileName = srcFile.getName();

		// 判断目标路径是否存在,如果不存在则创建目标路径
		File path1 = new File(desPath);
		if (!path1.exists()) {
			System.out.println("创建目录是否成功:" + path1.mkdirs());
		}

		// 组织目标文件
		String desFile = desPath + File.separator + fileName;

		// 声明低级流
		FileInputStream fin = null;
		FileOutputStream fout = null;

		// 声明高级流
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		try {
			// 首先初始化低级流
			// FileInputStream/FileOutputStream只能读写文件,而不能读写目录
			fin = new FileInputStream(srcFile); //
			fout = new FileOutputStream(desFile);

			// 后初始化高级流
			bin = new BufferedInputStream(fin);
			bout = new BufferedOutputStream(fout);

			int i = 0;
			byte[] b = new byte[1024 * 1024];

			while ((i = bin.read(b)) != -1) {
				bout.write(b, 0, i);
			}
			// bout.flush();

			System.out.println(srcFile.toString() + "拷贝到" + desFile + "完成");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ////////////////////////////////////////////////////////////////
			// 错误的关闭方式:关闭低级流
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
			// 正确的关闭方式:关闭高级流
			try {
				if (bin != null) {
					bin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (bout != null) {
					// 关闭高级流的时候高级流缓冲中的数据会被自动的刷新
					bout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 拷贝目录的功能
	 * 
	 * @param srcPath
	 *            源目录
	 * @param desPath
	 *            目标路径
	 */
	public static void copyDir(String srcPath, String desPath) {
		copyDir(new File(srcPath), desPath);
	}

	/**
	 * 拷贝目录的功能
	 * 
	 * @param srcPath
	 *            源目录
	 * @param desPath
	 *            目标路径
	 */
	public static void copyDir(File srcPath, String desPath) {
		// 判断srcPath是文件还是路径
		if (srcPath.isFile()) { // 文件
			copyFile(srcPath, desPath); // 直接调用拷贝文件的方法
		} else {// 路径
			// 从源目录中获取要拷贝的路面的名称,也就是从"C:\\Java\\jdk1.7.0_75\\src"其中获取到src
			String pathName = srcPath.getName();

			// 在目标路径中创建要拷贝的路径,例如:在d:\\ 创建src目录
			String dPath = desPath + File.separator + pathName;
			File path1 = new File(dPath);
			path1.mkdirs();

			// 获取源目录中所有的子文件
			File[] files = srcPath.listFiles();

			// 遍历数组,一个一个的拷贝
			for (File file : files) {
				// 直接递归调用
				copyDir(file, dPath);
			}
		}
	}
}
