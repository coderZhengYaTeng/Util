package com.powernode.io.test7;

import java.io.*;

// 包工头

public class FileCopyer {
	private File srcFile;// 源文件
	private String desFile; // 目标文件
	private String tempFile;// 拷贝过程中的临时文件名
	private int splitCount; // 文件切分的份数

	public FileCopyer(String srcFile, String desPath, int splitCount) {
		this(new File(srcFile), desPath, splitCount);
	}

	public FileCopyer(File srcFile, String desPath, int splitCount) {
		super();
		this.srcFile = srcFile;
		// 组织目标文件
		String fileName = srcFile.getName();
		this.desFile = desPath + File.separator + fileName;
		this.splitCount = splitCount;
		this.tempFile = this.desFile + ".td";
	}

	public void start() {
		// 获取文件的总的大小
		long fileSize = srcFile.length();

		// 根据切分的份数和文件总的大小计算每个工人的平均工作量
		long perWorkerSize = fileSize / splitCount;

		// 计算第一个工人的开始位置和结束位置
		long startPost = 0L;
		long endPost = perWorkerSize;

		// 创建多名工人
		for (int i = 0; i < this.splitCount; i++) {
			FileCopyWorker worker = new FileCopyWorker("工人-" + i, srcFile,
					tempFile, startPost, endPost);
			worker.start();

			// 计算下一个工人的开始位置和结束位置
			startPost = endPost;
			endPost = startPost + perWorkerSize;

			if (i == this.splitCount - 2) {
				endPost = fileSize;
			}
		}

		// 文件拷贝完成之后,把临时文件名称改成目标文件名称
		File f1 = new File(this.tempFile);
		File f2 = new File(this.desFile);

		System.out.println("重命名是否成功:" + f1.renameTo(f2));
	}

}
