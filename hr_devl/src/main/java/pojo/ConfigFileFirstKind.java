package pojo;

/**
 * ConfigFileFirstKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileFirstKind implements java.io.Serializable {

	// Fields

	private short ffkId;
	private String firstKindId;
	private String firstKindName;
	private String firstKindSalaryId;
	private String firstKindSaleId;

	// Constructors

	/** default constructor */
	public ConfigFileFirstKind() {
	}

	/** full constructor */
	public ConfigFileFirstKind(String firstKindId, String firstKindName, String firstKindSalaryId,
			String firstKindSaleId) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.firstKindSalaryId = firstKindSalaryId;
		this.firstKindSaleId = firstKindSaleId;
	}

	// Property accessors

	public Short getFfkId() {
		return this.ffkId;
	}

	public void setFfkId(Short ffkId) {
		this.ffkId = ffkId;
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

	public String getFirstKindSalaryId() {
		return this.firstKindSalaryId;
	}

	public void setFirstKindSalaryId(String firstKindSalaryId) {
		this.firstKindSalaryId = firstKindSalaryId;
	}

	public String getFirstKindSaleId() {
		return this.firstKindSaleId;
	}

	public void setFirstKindSaleId(String firstKindSaleId) {
		this.firstKindSaleId = firstKindSaleId;
	}

	@Override
	public String toString() {
		return "ConfigFileFirstKind [ffkId=" + ffkId + ", firstKindId=" + firstKindId + ", firstKindName="
				+ firstKindName + ", firstKindSalaryId=" + firstKindSalaryId + ", firstKindSaleId=" + firstKindSaleId
				+ "]";
	}

}