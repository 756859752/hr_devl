package  pojo;

import java.sql.Timestamp;

/**
 * Training entity. @author MyEclipse Persistence Tools
 */

public class Training implements java.io.Serializable {

	// Fields

	private Short traId;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private String humanId;
	private String humanName;
	private String trainingItem;
	private Timestamp trainingTime;
	private Integer trainingHour;
	private String trainingDegree;
	private String register;
	private String checker;
	private Timestamp registTime;
	private Timestamp checkTime;
	private Short checkstatus;
	private String remark;

	// Constructors

	/** default constructor */
	public Training() {
	}

	/** minimal constructor */
	public Training(Timestamp trainingTime, Timestamp registTime, Timestamp checkTime) {
		this.trainingTime = trainingTime;
		this.registTime = registTime;
		this.checkTime = checkTime;
	}

	/** full constructor */
	public Training(String majorKindId, String majorKindName, String majorId, String majorName, String humanId,
			String humanName, String trainingItem, Timestamp trainingTime, Integer trainingHour, String trainingDegree,
			String register, String checker, Timestamp registTime, Timestamp checkTime, Short checkstatus,
			String remark) {
		this.majorKindId = majorKindId;
		this.majorKindName = majorKindName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.humanId = humanId;
		this.humanName = humanName;
		this.trainingItem = trainingItem;
		this.trainingTime = trainingTime;
		this.trainingHour = trainingHour;
		this.trainingDegree = trainingDegree;
		this.register = register;
		this.checker = checker;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.checkstatus = checkstatus;
		this.remark = remark;
	}

	// Property accessors

	public Short getTraId() {
		return this.traId;
	}

	public void setTraId(Short traId) {
		this.traId = traId;
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


	public String getHumanId() {
		return this.humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}


	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}


	public String getTrainingItem() {
		return this.trainingItem;
	}

	public void setTrainingItem(String trainingItem) {
		this.trainingItem = trainingItem;
	}


	public Timestamp getTrainingTime() {
		return this.trainingTime;
	}

	public void setTrainingTime(Timestamp trainingTime) {
		this.trainingTime = trainingTime;
	}


	public Integer getTrainingHour() {
		return this.trainingHour;
	}

	public void setTrainingHour(Integer trainingHour) {
		this.trainingHour = trainingHour;
	}


	public String getTrainingDegree() {
		return this.trainingDegree;
	}

	public void setTrainingDegree(String trainingDegree) {
		this.trainingDegree = trainingDegree;
	}


	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}


	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}


	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}


	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}


	public Short getCheckstatus() {
		return this.checkstatus;
	}

	public void setCheckstatus(Short checkstatus) {
		this.checkstatus = checkstatus;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}