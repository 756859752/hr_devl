package  pojo;

import java.sql.Timestamp;

/**
 * EngageMajorRelease entity. @author MyEclipse Persistence Tools
 */

public class EngageMajorRelease implements java.io.Serializable {

	// Fields

	private Short mreId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private Short humanAmount;
	private String engageType;
	private Timestamp deadline;
	private String register;
	private String changer;
	private Timestamp registTime;
	private Timestamp changeTime;
	private String majorDescribe;
	private String engageRequired;

	// Constructors

	/** default constructor */
	public EngageMajorRelease() {
	}

	/** minimal constructor */
	public EngageMajorRelease(Timestamp deadline, Timestamp registTime, Timestamp changeTime) {
		this.deadline = deadline;
		this.registTime = registTime;
		this.changeTime = changeTime;
	}

	/** full constructor */
	public EngageMajorRelease(String firstKindId, String firstKindName, String secondKindId, String secondKindName,
			String thirdKindId, String thirdKindName, String majorKindId, String majorKindName, String majorId,
			String majorName, Short humanAmount, String engageType, Timestamp deadline, String register, String changer,
			Timestamp registTime, Timestamp changeTime, String majorDescribe, String engageRequired) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.humanAmount = humanAmount;
		this.engageType = engageType;
		this.deadline = deadline;
		this.register = register;
		this.changer = changer;
		this.registTime = registTime;
		this.changeTime = changeTime;
		this.majorDescribe = majorDescribe;
		this.engageRequired = engageRequired;
	}


	public Short getMreId() {
		return this.mreId;
	}

	public void setMreId(Short mreId) {
		this.mreId = mreId;
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


	public String getThirdKindId() {
		return this.thirdKindId;
	}

	public void setThirdKindId(String thirdKindId) {
		this.thirdKindId = thirdKindId;
	}


	public String getThirdKindName() {
		return this.thirdKindName;
	}

	public void setThirdKindName(String thirdKindName) {
		this.thirdKindName = thirdKindName;
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


	public Short getHumanAmount() {
		return this.humanAmount;
	}

	public void setHumanAmount(Short humanAmount) {
		this.humanAmount = humanAmount;
	}


	public String getEngageType() {
		return this.engageType;
	}

	public void setEngageType(String engageType) {
		this.engageType = engageType;
	}


	public Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}


	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}


	public String getChanger() {
		return this.changer;
	}

	public void setChanger(String changer) {
		this.changer = changer;
	}


	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}


	public Timestamp getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}


	public String getMajorDescribe() {
		return this.majorDescribe;
	}

	public void setMajorDescribe(String majorDescribe) {
		this.majorDescribe = majorDescribe;
	}


	public String getEngageRequired() {
		return this.engageRequired;
	}

	public void setEngageRequired(String engageRequired) {
		this.engageRequired = engageRequired;
	}

}