package com.powernode.io.test7;

import java.io.*;

// ����ͷ

public class FileCopyer {
	private File srcFile;// Դ�ļ�
	private String desFile; // Ŀ���ļ�
	private String tempFile;// ���������е���ʱ�ļ���
	private int splitCount; // �ļ��зֵķ���

	public FileCopyer(String srcFile, String desPath, int splitCount) {
		this(new File(srcFile), desPath, splitCount);
	}

	public FileCopyer(File srcFile, String desPath, int splitCount) {
		super();
		this.srcFile = srcFile;
		// ��֯Ŀ���ļ�
		String fileName = srcFile.getName();
		this.desFile = desPath + File.separator + fileName;
		this.splitCount = splitCount;
		this.tempFile = this.desFile + ".td";
	}

	public void start() {
		// ��ȡ�ļ����ܵĴ�С
		long fileSize = srcFile.length();

		// �����зֵķ������ļ��ܵĴ�С����ÿ�����˵�ƽ��������
		long perWorkerSize = fileSize / splitCount;

		// �����һ�����˵Ŀ�ʼλ�úͽ���λ��
		long startPost = 0L;
		long endPost = perWorkerSize;

		// ������������
		for (int i = 0; i < this.splitCount; i++) {
			FileCopyWorker worker = new FileCopyWorker("����-" + i, srcFile,
					tempFile, startPost, endPost);
			worker.start();

			// ������һ�����˵Ŀ�ʼλ�úͽ���λ��
			startPost = endPost;
			endPost = startPost + perWorkerSize;

			if (i == this.splitCount - 2) {
				endPost = fileSize;
			}
		}

		// �ļ��������֮��,����ʱ�ļ����Ƹĳ�Ŀ���ļ�����
		File f1 = new File(this.tempFile);
		File f2 = new File(this.desFile);

		System.out.println("�������Ƿ�ɹ�:" + f1.renameTo(f2));
	}

}
