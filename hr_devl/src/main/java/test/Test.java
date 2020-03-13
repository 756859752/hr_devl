package test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ConfigPublicCharMapper;
import pojo.ConfigPublicChar;
public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println(Test.getSql());
		System.out.println();
		System.out.println(Test.getquchu());
		System.out.println();
		System.out.println(Test.getupdate());
		System.out.println();
		System.out.println(Test.getResultMapString());
		//ConfigQuestionFirstKindMapper
	}

	public static String getSql() throws Exception {
		FileInputStream fs = new FileInputStream("d:/hr.txt");
		byte[] b = new byte[fs.available()];
		fs.read(b);
		String s = new String(b);
		s = s.replaceAll("\r\n", ",");
		return s;
	}

	public static String getquchu() throws Exception {
		FileInputStream fs = new FileInputStream("d:/hr.txt");
		byte[] b = new byte[fs.available()];
		fs.read(b);
		String s = new String(b);
		StringBuffer sb = new StringBuffer("");
		StringTokenizer st = new StringTokenizer(s, "\r\n");
		while (st.hasMoreTokens()) {
			sb.append("#{");
			sb.append(toup(st.nextToken()));
			sb.append("}");
			if (st.hasMoreTokens()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static String getupdate() throws Exception {
		FileInputStream fs = new FileInputStream("d:/hr.txt");
		byte[] b = new byte[fs.available()];
		fs.read(b);
		String s = new String(b);
		StringBuffer sb = new StringBuffer("");
		StringTokenizer st = new StringTokenizer(s, "\r\n");
		while (st.hasMoreTokens()) {
			String sitem = st.nextToken();
			String spre = toup(sitem);
			sb.append(sitem + "=");
			sb.append("#{");
			sb.append(spre);
			sb.append("}");
			if (st.hasMoreTokens()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static String toup(String st) {// 变成驼峰命名
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

	public static String getResultMapString() throws Exception {
		FileInputStream fs = new FileInputStream("d:/hr.txt");
		byte[] b = new byte[fs.available()];
		fs.read(b);
		String s = new String(b);
		StringTokenizer st = new StringTokenizer(s, "\r\n");

		StringBuffer sb = new StringBuffer();
		sb.append("	<resultMap type=\"Teacher\" id=\"tid\" >");
		int flag = 0;
		while (st.hasMoreTokens()) {
			String stcolumn = st.nextToken();
			sb.append("\r\n");
			if (flag == 0) {
				sb.append("<id property=\"");
			} else {
				sb.append("<result property=\"");
			}
			sb.append(toup(stcolumn));
			sb.append("\" column=\"");
			sb.append(stcolumn);
			sb.append("\"/>");
			flag = 1;
		}
		sb.append("   </resultMap>");
		return sb.toString();
	}
}
