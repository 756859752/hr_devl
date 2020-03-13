package pojo;

import java.sql.Timestamp;

/**
 * EngageInterview entity. @author MyEclipse Persistence Tools
 */

public class EngageInterview implements java.io.Serializable {

	// Fields

	private Short einId;
	private String humanName;
	private Short interviewAmount;
	private String humanMajorKindId;
	private String humanMajorKindName;
	private String humanMajorId;
	private String humanMajorName;
	private String imageDegree;
	private String nativeLanguageDegree;
	private String foreignLanguageDegree;
	private String responseSpeedDegree;
	private String eqDegree;
	private String iqDegree;
	private String multiQualityDegree;
	private String register;
	private String checker;
	private Timestamp registeTime;
	private Timestamp checkTime;
	private Short resumeId;
	private String result;
	private String interviewComment;
	private String checkComment;
	private Short interviewStatus;
	private Short checkStatus;

	// Constructors

	/** default constructor */
	public EngageInterview() {
	}

	/** minimal constructor */
	public EngageInterview(Timestamp registeTime, Timestamp checkTime) {
		this.registeTime = registeTime;
		this.checkTime = checkTime;
	}

	/** full constructor */
	public EngageInterview(String humanName, Short interviewAmount, String humanMajorKindId, String humanMajorKindName,
			String humanMajorId, String humanMajorName, String imageDegree, String nativeLanguageDegree,
			String foreignLanguageDegree, String responseSpeedDegree, String eqDegree, String iqDegree,
			String multiQualityDegree, String register, String checker, Timestamp registeTime, Timestamp checkTime,
			Short resumeId, String result, String interviewComment, String checkComment, Short interviewStatus,
			Short checkStatus) {
		this.humanName = humanName;
		this.interviewAmount = interviewAmount;
		this.humanMajorKindId = humanMajorKindId;
		this.humanMajorKindName = humanMajorKindName;
		this.humanMajorId = humanMajorId;
		this.humanMajorName = humanMajorName;
		this.imageDegree = imageDegree;
		this.nativeLanguageDegree = nativeLanguageDegree;
		this.foreignLanguageDegree = foreignLanguageDegree;
		this.responseSpeedDegree = responseSpeedDegree;
		this.eqDegree = eqDegree;
		this.iqDegree = iqDegree;
		this.multiQualityDegree = multiQualityDegree;
		this.register = register;
		this.checker = checker;
		this.registeTime = registeTime;
		this.checkTime = checkTime;
		this.resumeId = resumeId;
		this.result = result;
		this.interviewComment = interviewComment;
		this.checkComment = checkComment;
		this.interviewStatus = interviewStatus;
		this.checkStatus = checkStatus;
	}

	// Property accessors

	public Short getEinId() {
		return this.einId;
	}

	public void setEinId(Short einId) {
		this.einId = einId;
	}

	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public Short getInterviewAmount() {
		return this.interviewAmount;
	}

	public void setInterviewAmount(Short interviewAmount) {
		this.interviewAmount = interviewAmount;
	}

	public String getHumanMajorKindId() {
		return this.humanMajorKindId;
	}

	public void setHumanMajorKindId(String humanMajorKindId) {
		this.humanMajorKindId = humanMajorKindId;
	}

	public String getHumanMajorKindName() {
		return this.humanMajorKindName;
	}

	public void setHumanMajorKindName(String humanMajorKindName) {
		this.humanMajorKindName = humanMajorKindName;
	}

	public String getHumanMajorId() {
		return this.humanMajorId;
	}

	public void setHumanMajorId(String humanMajorId) {
		this.humanMajorId = humanMajorId;
	}

	public String getHumanMajorName() {
		return this.humanMajorName;
	}

	public void setHumanMajorName(String humanMajorName) {
		this.humanMajorName = humanMajorName;
	}

	public String getImageDegree() {
		return this.imageDegree;
	}

	public void setImageDegree(String imageDegree) {
		this.imageDegree = imageDegree;
	}

	public String getNativeLanguageDegree() {
		return this.nativeLanguageDegree;
	}

	public void setNativeLanguageDegree(String nativeLanguageDegree) {
		this.nativeLanguageDegree = nativeLanguageDegree;
	}

	public String getForeignLanguageDegree() {
		return this.foreignLanguageDegree;
	}

	public void setForeignLanguageDegree(String foreignLanguageDegree) {
		this.foreignLanguageDegree = foreignLanguageDegree;
	}

	public String getResponseSpeedDegree() {
		return this.responseSpeedDegree;
	}

	public void setResponseSpeedDegree(String responseSpeedDegree) {
		this.responseSpeedDegree = responseSpeedDegree;
	}

	public String getEqDegree() {
		return this.eqDegree;
	}

	public void setEqDegree(String eqDegree) {
		this.eqDegree = eqDegree;
	}

	public String getIqDegree() {
		return this.iqDegree;
	}

	public void setIqDegree(String iqDegree) {
		this.iqDegree = iqDegree;
	}

	public String getMultiQualityDegree() {
		return this.multiQualityDegree;
	}

	public void setMultiQualityDegree(String multiQualityDegree) {
		this.multiQualityDegree = multiQualityDegree;
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

	public Timestamp getRegisteTime() {
		return this.registeTime;
	}

	public void setRegisteTime(Timestamp registeTime) {
		this.registeTime = registeTime;
	}

	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public Short getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Short resumeId) {
		this.resumeId = resumeId;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInterviewComment() {
		return this.interviewComment;
	}

	public void setInterviewComment(String interviewComment) {
		this.interviewComment = interviewComment;
	}

	public String getCheckComment() {
		return this.checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	public Short getInterviewStatus() {
		return this.interviewStatus;
	}

	public void setInterviewStatus(Short interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public Short getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
	}

}