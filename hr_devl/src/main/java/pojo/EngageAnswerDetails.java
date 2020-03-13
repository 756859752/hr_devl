package pojo;

/**
 * EngageAnswerDetails entity. @author MyEclipse Persistence Tools
 */

public class EngageAnswerDetails implements java.io.Serializable {

	// Fields

	private Short andId;
	private String answerNumber;
	private Short subjectId;
	private String answer;

	// Constructors

	/** default constructor */
	public EngageAnswerDetails() {
	}

	/** full constructor */
	public EngageAnswerDetails(String answerNumber, Short subjectId, String answer) {
		this.answerNumber = answerNumber;
		this.subjectId = subjectId;
		this.answer = answer;
	}

	// Property accessors

	public Short getAndId() {
		return this.andId;
	}

	public void setAndId(Short andId) {
		this.andId = andId;
	}

	public String getAnswerNumber() {
		return this.answerNumber;
	}

	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}

	public Short getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Short subjectId) {
		this.subjectId = subjectId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}