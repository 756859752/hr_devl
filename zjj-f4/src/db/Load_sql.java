package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Load_sql {
	 static Properties pp=new Properties();
	/***
	 *  ���� 
	 */
	static {
			try {
			pp.load(Load_sql.class.getResourceAsStream("/db.properties"));
			Class.forName(pp.getProperty("driver"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
			}
	
	/***
	 *  ��������
	 * 
	 */
 public static Connection jiazai() {
	    Connection conn=null;
	try {
		 conn=DriverManager.getConnection(pp.getProperty("utl"),pp.getProperty("zhanghao"),pp.getProperty("parssword"));
		System.out.println(conn);
	} catch (SQLException e) {
		e.printStackTrace();
	
 }
	return conn ;	 
 }
 /***
  *  �ر�����
  */
 public static void myclose(Connection connection) {
	try {
		if (connection!=null&&!connection.isClosed()) {
			connection.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
