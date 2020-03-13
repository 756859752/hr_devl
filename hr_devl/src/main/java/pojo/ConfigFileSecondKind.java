package pojo;

/**
 * ConfigFileSecondKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileSecondKind implements java.io.Serializable {

	// Fields

	private Short fskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String secondSalaryId;
	private String secondSaleId;

	// Constructors

	/** default constructor */
	public ConfigFileSecondKind() {
	}

	/** full constructor */
	public ConfigFileSecondKind(String firstKindId, String firstKindName, String secondKindId, String secondKindName,
			String secondSalaryId, String secondSaleId) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.secondSalaryId = secondSalaryId;
		this.secondSaleId = secondSaleId;
	}

	// Property accessors

	public Short getFskId() {
		return this.fskId;
	}

	public void setFskId(Short fskId) {
		this.fskId = fskId;
	}

	public String getFirstKindId() {
		return this.firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getSecondKindId() {
		return this.secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	public String getSecondSalaryId() {
		return this.secondSalaryId;
	}

	public void setSecondSalaryId(String secondSalaryId) {
		this.secondSalaryId = secondSalaryId;
	}

	public String getSecondSaleId() {
		return this.secondSaleId;
	}

	public void setSecondSaleId(String secondSaleId) {
		this.secondSaleId = secondSaleId;
	}

	@Override
	public String toString() {
		return "ConfigFileSecondKind [fskId=" + fskId + ", firstKindId="
				+ firstKindId + ", firstKindName=" + firstKindName
				+ ", secondKindId=" + secondKindId + ", secondKindName="
				+ secondKindName + ", secondSalaryId=" + secondSalaryId
				+ ", secondSaleId=" + secondSaleId + "]";
	}

}