package com.powernode.io.test7;

import java.io.*;

// 干活的工人

public class FileCopyWorker {
	private String name; // 工人的名字
	private File srcFile;// 源文件
	private String desFile;// 目标文件
	private long startPost; // 开始位置
	private long endPost; // 结束位置
	private long copyedPost;// 已经拷贝的位置

	public FileCopyWorker(String name, File srcFile, String desFile,
			long startPost, long endPost) {
		super();
		this.name = name;
		this.srcFile = srcFile;
		this.desFile = desFile;
		this.startPost = startPost;
		this.endPost = endPost;
		this.copyedPost = this.startPost;
		// System.out.println(name + "开始位置是:" + this.startPost + ",结束位置是:" +
		// endPost);
	}

	public void start() {
		RandomAccessFile rin = null;
		RandomAccessFile rout = null;

		try {
			rin = new RandomAccessFile(this.srcFile, "r");
			rout = new RandomAccessFile(this.desFile, "rw");

			// 定位读写的位置
			rin.seek(this.startPost);
			rout.seek(this.startPost);

			int i = 0;
			byte[] b = new byte[1024 * 1024];
			while ((this.copyedPost < this.endPost) && (i = rin.read(b)) != -1) {
				if ((this.copyedPost + i) > this.endPost) {
					i = (int) (this.endPost - this.copyedPost);
				}
				rout.write(b, 0, i);
				this.copyedPost += i;
				System.out.println( "正在工作,已经拷贝的位置是:" + this.copyedPost + ",结束位置是:" + this.endPost);
			}
			
			System.err.println( "结束工作,已经拷贝的位置是:" + this.copyedPost + ",结束位置是:" + this.endPost);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rin != null) {
					rin.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rout != null) {
					rout.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
