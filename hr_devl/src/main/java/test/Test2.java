package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2 {
	public static void main(String[] args) throws Exception {
//		InputStreamReader ir=new InputStreamReader(new FileInputStream("d:/hr.txt"));
		FileInputStream fs = new FileInputStream("d:/hr.txt");
		byte[] b = new byte[fs.available()];
		fs.read(b);
		String s = new String(b);
		StringTokenizer st = new StringTokenizer(s, "\r\n");

		StringBuffer sb = new StringBuffer();
		sb.append("	<resultMap type=\"Teacher\" id=\"tid\" >");
		while (st.hasMoreTokens()) {
			String stcolumn = st.nextToken();
			sb.append("\r\n");
			sb.append("<id property=\"");
			sb.append(toup(stcolumn));
			sb.append("\"column=\"");
			sb.append(stcolumn);
			sb.append("\"/>");
			sb.append("\r\n");
		}
		sb.append("   </resultMap>");

		System.out.println(sb.toString());
	}

	public static String toup(String st) {
		String rst = "";
		StringTokenizer stz = new StringTokenizer(st, "_");
		int flag = 0;
		while (stz.hasMoreTokens()) {
			String stemp = stz.nextToken();
			String stemp2 = "";
			if (flag == 1) {
				stemp2 = stemp.substring(0, 1).toUpperCase() + stemp.substring(1);
				rst += stemp2;
			} else {
				stemp2 = stemp;
				rst += stemp2;
			}
			flag = 1;
		}
		return rst;
	}
}
