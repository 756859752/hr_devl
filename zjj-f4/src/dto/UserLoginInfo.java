package dto;

import java.io.Serializable;
import java.util.Date;
/**
 * ����һ���û���½ʱ��¼�û���½��Ϣ����
 * @author Administrator
 *
 */
public class UserLoginInfo implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9122617988549861001L;
	//�û�id
	private int userid;
	//�û��˺�
	private String username;
	//�û���½��ip��ַ
	private String ip;
	//�û���½��ʱ��
	private Date logindate;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
