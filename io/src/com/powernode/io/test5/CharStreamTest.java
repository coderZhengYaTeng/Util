package com.powernode.io.test5;

import java.io.*;

public class CharStreamTest {

	public static void readFile1() {
		FileReader fr = null;
		try {
			fr = new FileReader("c:\\aa.txt");

			int i = 0;
			// 读取单个字符,当做int返回,判断int是否等于-1
			while ((i = fr.read()) != -1) {
				// char -> int -> char
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void readFile2() {
		FileReader fr = null;
		try {
			fr = new FileReader("c:\\aa.txt");

			int i = 0;
			char[] b = new char[200];

			// i是读取到的字符的数量
			while ((i = fr.read(b)) != -1) {
				// char [] -> String
				String str = new String(b, 0, i);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void readFile3() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\aa.txt");
			br = new BufferedReader(fr);

			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void readKeyBoard() {
		// InputStream in = System.in;
		// InputStreamReader isr = new InputStreamReader(in);
		// BufferedReader br = new BufferedReader(isr);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请从键盘输入数据并回车确认:");

		while (true) {
			try {
				String str = br.readLine();
				// 处理空格
				if (str.trim().length() == 0) {
					continue;
				}
				// 处理退出
				if ("exit".equalsIgnoreCase(str)) {
					break;
				}
				System.out.println("【键盘数据】" + str);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeFile1() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("bb.txt", true);

			for (int i = 1; i <= 100; i++) {
				String str = i
						+ ".要自己指定这些值，可以先在 FileOutputStream 上构造一个 OutputStreamWriter。 ";
				fw.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void writeFile2() {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("bb.txt", true);
			pw = new PrintWriter(fw);

			for (int i = 1; i <= 100; i++) {
				String str = i
						+ ".要自己指定这些值，可以先在 FileOutputStream 上构造一个 OutputStreamWriter。 ";
				pw.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pw != null) {
				pw.close();
			}

		}

	}

	public static void main(String[] args) {
		// readFile1();
		// readFile2();
		// readFile3();
		// readKeyBoard();
		writeFile2();
	}

}
