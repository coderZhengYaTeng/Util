package httpClient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("是否开始检测（1开始）");
		String start = sc.nextLine();
		if ("1".equals(start)) {
			// String i = "123";
			// String j = "9492933505127618580-1874836273/29:DD:B8:CE:C3:8A";
			// String strcode = StringSecUtils.encode(i, j);
			// String str=i+"-"+strcode;
			CloseableHttpClient closeableHttpClient = null;
			try {
				copy();
				/*String str = readFile(new File("D:\\mpen.txt"));
				String[] split = str.split("-");
				String k = split[0].trim();
				String b = split[1].trim();
				String m = MD5Util.GetMD5Code(k + b);
				// 创建HttpClientBuilder
				HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
				// HttpClient
				closeableHttpClient = httpClientBuilder.build();
				String url = "http://192.168.44.176/mobile/open/u/saveCheckPen.json?entity.k=" + k + "&entity.b=" + b + "&entity.m=" + m;
				HttpGet httpGet = new HttpGet(url);

				// 执行get请求
				HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
				// 获取响应消息实体
				HttpEntity entity = httpResponse.getEntity();
				// 响应状态
				StatusLine statusLine = httpResponse.getStatusLine();
				// 判断响应实体是否为空
				if (entity != null) {
					String json = EntityUtils.toString(entity);
					JSONObject jsonObject = JSONObject.fromObject(json);
					String message = (String) jsonObject.get("message");
					System.out.println(message);
				}*/
			} catch (Exception e) {
				System.out.println("文件不存在！");
				e.printStackTrace();
			} finally {
				try {
					closeableHttpClient.close();
				} catch (IOException e) {

				}
			}
		}

	}

	public static String readFile(File srcFile) throws Exception {
		StringBuffer sb = new StringBuffer();
		FileInputStream fin = null;
		BufferedInputStream bin = null;
		fin = new FileInputStream(srcFile); //
		bin = new BufferedInputStream(fin);
		int i = 0;
		byte[] b = new byte[1024 * 1024];
		while ((i = bin.read(b)) != -1) {
			sb.append(new String(b, "UTF-8"));
		}
		if (bin != null) {
			bin.close();
		}
		return sb.toString();
	}

	public static boolean copy() {
		// 文件命名
		List<String> commend = new ArrayList<String>();
		commend.add("adb pull /storage/emulated/legacy/mpen.txt D:/");
		Process proce = null;
		try {
			Runtime runtime = Runtime.getRuntime();
			String cmd = "";
			String cut = "adb pull /storage/emulated/legacy/mpen.txt D:/";
			String cutCmd = cmd + cut;
			proce = runtime.exec(cutCmd);
			ProcessBuilder builder = new ProcessBuilder(commend);
			builder.command(commend);
			builder.start();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
