package pojo;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Short uId;
	private String uName;
	private String uTrueName;
	private String uPassword;
	private String uMajorName;
	// Constructors

	/** default constructor */
	public Users() {
	}

	public Short getuId() {
		return uId;
	}

	public void setuId(Short uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuTrueName() {
		return uTrueName;
	}

	public void setuTrueName(String uTrueName) {
		this.uTrueName = uTrueName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuMajorName() {
		return uMajorName;
	}

	public void setuMajorName(String uMajorName) {
		this.uMajorName = uMajorName;
	}



}