package com.powernode.io.test7;

import java.io.*;

// �ɻ�Ĺ���

public class FileCopyWorker {
	private String name; // ���˵�����
	private File srcFile;// Դ�ļ�
	private String desFile;// Ŀ���ļ�
	private long startPost; // ��ʼλ��
	private long endPost; // ����λ��
	private long copyedPost;// �Ѿ�������λ��

	public FileCopyWorker(String name, File srcFile, String desFile,
			long startPost, long endPost) {
		super();
		this.name = name;
		this.srcFile = srcFile;
		this.desFile = desFile;
		this.startPost = startPost;
		this.endPost = endPost;
		this.copyedPost = this.startPost;
		// System.out.println(name + "��ʼλ����:" + this.startPost + ",����λ����:" +
		// endPost);
	}

	public void start() {
		RandomAccessFile rin = null;
		RandomAccessFile rout = null;

		try {
			rin = new RandomAccessFile(this.srcFile, "r");
			rout = new RandomAccessFile(this.desFile, "rw");

			// ��λ��д��λ��
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
				System.out.println( "���ڹ���,�Ѿ�������λ����:" + this.copyedPost + ",����λ����:" + this.endPost);
			}
			
			System.err.println( "��������,�Ѿ�������λ����:" + this.copyedPost + ",����λ����:" + this.endPost);

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
