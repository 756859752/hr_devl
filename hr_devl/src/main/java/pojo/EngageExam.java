package pojo;

import java.sql.Timestamp;

/**
 * EngageExam entity. @author MyEclipse Persistence Tools
 */

public class EngageExam implements java.io.Serializable {

	// Fields

	private Short exaId;
	private String examNumber;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private String register;
	private Timestamp registTime;
	private Short limiteTime;
	private int amout;
	// Constructors

	/** default constructor */
	public EngageExam() {
	}

	/** minimal constructor */
	public EngageExam(Timestamp registTime) {
		this.registTime = registTime;
	}

	/** full constructor */
	public EngageExam(String examNumber, String majorKindId, String majorKindName, String majorId, String majorName,
			String register, Timestamp registTime, Short limiteTime) {
		this.examNumber = examNumber;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.register = register;
		this.registTime = registTime;
		this.limiteTime = limiteTime;
	}

	// Property accessors

	public Short getExaId() {
		return this.exaId;
	}

	public void setExaId(Short exaId) {
		this.exaId = exaId;
	}

	public String getExamNumber() {
		return this.examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public Short getLimiteTime() {
		return this.limiteTime;
	}

	public void setLimiteTime(Short limiteTime) {
		this.limiteTime = limiteTime;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

	@Override
	public String toString() {
		return "EngageExam [exaId=" + exaId + ", examNumber=" + examNumber
				+ ", majorKindId=" + majorKindId + ", majorKindName="
				+ majorKindName + ", majorId=" + majorId + ", majorName="
				+ majorName + ", register=" + register + ", registTime="
				+ registTime + ", limiteTime=" + limiteTime + "]";
	}
	
}