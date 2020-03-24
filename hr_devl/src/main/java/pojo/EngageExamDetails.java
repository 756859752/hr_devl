package pojo;

/**
 * EngageExamDetails entity. @author MyEclipse Persistence Tools
 */

public class EngageExamDetails implements java.io.Serializable {

	// Fields

	private Short exdId;
	private String examNumber;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private Short questionAmount;
	
	// Constructors

	/** default constructor */
	public EngageExamDetails() {
	}

	/** full constructor */
	public EngageExamDetails(String examNumber, String firstKindId, String firstKindName, String secondKindId,
			String secondKindName, Short questionAmount) {
		this.examNumber = examNumber;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.questionAmount = questionAmount;
	}

	public Short getExdId() {
		return this.exdId;
	}

	public void setExdId(Short exdId) {
		this.exdId = exdId;
	}

	public String getExamNumber() {
		return this.examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
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

	public Short getQuestionAmount() {
		return this.questionAmount;
	}

	public void setQuestionAmount(Short questionAmount) {
		this.questionAmount = questionAmount;
	}

	@Override
	public String toString() {
		return "EngageExamDetails [exdId=" + exdId + ", examNumber="
				+ examNumber + ", firstKindId=" + firstKindId
				+ ", firstKindName=" + firstKindName + ", secondKindId="
				+ secondKindId + ", secondKindName=" + secondKindName
				+ ", questionAmount=" + questionAmount + "]";
	}

}