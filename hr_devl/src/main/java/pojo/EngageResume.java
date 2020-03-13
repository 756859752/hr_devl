package pojo;

import java.sql.Timestamp;

/**
 * EngageResume entity. @author MyEclipse Persistence Tools
 */

public class EngageResume implements java.io.Serializable {

	// Fields

	private Short resId;
	private String humanName;
	private String engageType;
	private String humanAddress;
	private String humanPostcode;
	private String humanMajorKindId;
	private String humanMajorKindName;
	private String humanMajorId;
	private String humanMajorName;
	private String humanTelephone;
	private String humanHomephone;
	private String humanMobilephone;
	private String humanEmail;
	private String humanHobby;
	private String humanSpecility;
	private String humanSex;
	private String humanReligion;
	private String humanParty;
	private String humanNationality;
	private String humanRace;
	private Timestamp humanBirthday;
	private Short humanAge;
	private String humanEducatedDegree;
	private Short humanEducatedYears;
	private String humanEducatedMajor;
	private String humanCollege;
	private String humanIdcard;
	private String humanBirthplace;
	private Double demandSalaryStandard;
	private String humanHistoryRecords;
	private String remark;
	private String recomandation;
	private String humanPicture;
	private String attachmentName;
	private Short checkStatus;
	private String register;
	private Timestamp registTime;
	private String checker;
	private Timestamp checkTime;
	private Short interviewStatus;
	private Double totalPoints;
	private Short testAmount;
	private String testChecker;
	private Timestamp testCheckTime;
	private String passRegister;
	private Timestamp passRegistTime;
	private String passChecker;
	private Timestamp passCheckTime;
	private Short passCheckStatus;
	private String passCheckComment;
	private String passPassComment;

	// Constructors

	/** default constructor */
	public EngageResume() {
	}

	/** minimal constructor */
	public EngageResume(Timestamp humanBirthday, Timestamp registTime, Timestamp checkTime, Timestamp testCheckTime,
			Timestamp passRegistTime, Timestamp passCheckTime) {
		this.humanBirthday = humanBirthday;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.testCheckTime = testCheckTime;
		this.passRegistTime = passRegistTime;
		this.passCheckTime = passCheckTime;
	}

	/** full constructor */
	public EngageResume(String humanName, String engageType, String humanAddress, String humanPostcode,
			String humanMajorKindId, String humanMajorKindName, String humanMajorId, String humanMajorName,
			String humanTelephone, String humanHomephone, String humanMobilephone, String humanEmail, String humanHobby,
			String humanSpecility, String humanSex, String humanReligion, String humanParty, String humanNationality,
			String humanRace, Timestamp humanBirthday, Short humanAge, String humanEducatedDegree,
			Short humanEducatedYears, String humanEducatedMajor, String humanCollege, String humanIdcard,
			String humanBirthplace, Double demandSalaryStandard, String humanHistoryRecords, String remark,
			String recomandation, String humanPicture, String attachmentName, Short checkStatus, String register,
			Timestamp registTime, String checker, Timestamp checkTime, Short interviewStatus, Double totalPoints,
			Short testAmount, String testChecker, Timestamp testCheckTime, String passRegister,
			Timestamp passRegistTime, String passChecker, Timestamp passCheckTime, Short passCheckStatus,
			String passCheckComment, String passPassComment) {
		this.humanName = humanName;
		this.engageType = engageType;
		this.humanAddress = humanAddress;
		this.humanPostcode = humanPostcode;
		this.humanMajorKindId = humanMajorKindId;
		this.humanMajorKindName = humanMajorKindName;
		this.humanMajorId = humanMajorId;
		this.humanMajorName = humanMajorName;
		this.humanTelephone = humanTelephone;
		this.humanHomephone = humanHomephone;
		this.humanMobilephone = humanMobilephone;
		this.humanEmail = humanEmail;
		this.humanHobby = humanHobby;
		this.humanSpecility = humanSpecility;
		this.humanSex = humanSex;
		this.humanReligion = humanReligion;
		this.humanParty = humanParty;
		this.humanNationality = humanNationality;
		this.humanRace = humanRace;
		this.humanBirthday = humanBirthday;
		this.humanAge = humanAge;
		this.humanEducatedDegree = humanEducatedDegree;
		this.humanEducatedYears = humanEducatedYears;
		this.humanEducatedMajor = humanEducatedMajor;
		this.humanCollege = humanCollege;
		this.humanIdcard = humanIdcard;
		this.humanBirthplace = humanBirthplace;
		this.demandSalaryStandard = demandSalaryStandard;
		this.humanHistoryRecords = humanHistoryRecords;
		this.remark = remark;
		this.recomandation = recomandation;
		this.humanPicture = humanPicture;
		this.attachmentName = attachmentName;
		this.checkStatus = checkStatus;
		this.register = register;
		this.registTime = registTime;
		this.checker = checker;
		this.checkTime = checkTime;
		this.interviewStatus = interviewStatus;
		this.totalPoints = totalPoints;
		this.testAmount = testAmount;
		this.testChecker = testChecker;
		this.testCheckTime = testCheckTime;
		this.passRegister = passRegister;
		this.passRegistTime = passRegistTime;
		this.passChecker = passChecker;
		this.passCheckTime = passCheckTime;
		this.passCheckStatus = passCheckStatus;
		this.passCheckComment = passCheckComment;
		this.passPassComment = passPassComment;
	}

	// Property accessors

	public Short getResId() {
		return this.resId;
	}

	public void setResId(Short resId) {
		this.resId = resId;
	}

	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getEngageType() {
		return this.engageType;
	}

	public void setEngageType(String engageType) {
		this.engageType = engageType;
	}

	public String getHumanAddress() {
		return this.humanAddress;
	}

	public void setHumanAddress(String humanAddress) {
		this.humanAddress = humanAddress;
	}

	public String getHumanPostcode() {
		return this.humanPostcode;
	}

	public void setHumanPostcode(String humanPostcode) {
		this.humanPostcode = humanPostcode;
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

	public String getHumanTelephone() {
		return this.humanTelephone;
	}

	public void setHumanTelephone(String humanTelephone) {
		this.humanTelephone = humanTelephone;
	}

	public String getHumanHomephone() {
		return this.humanHomephone;
	}

	public void setHumanHomephone(String humanHomephone) {
		this.humanHomephone = humanHomephone;
	}

	public String getHumanMobilephone() {
		return this.humanMobilephone;
	}

	public void setHumanMobilephone(String humanMobilephone) {
		this.humanMobilephone = humanMobilephone;
	}

	public String getHumanEmail() {
		return this.humanEmail;
	}

	public void setHumanEmail(String humanEmail) {
		this.humanEmail = humanEmail;
	}

	public String getHumanHobby() {
		return this.humanHobby;
	}

	public void setHumanHobby(String humanHobby) {
		this.humanHobby = humanHobby;
	}

	public String getHumanSpecility() {
		return this.humanSpecility;
	}

	public void setHumanSpecility(String humanSpecility) {
		this.humanSpecility = humanSpecility;
	}

	public String getHumanSex() {
		return this.humanSex;
	}

	public void setHumanSex(String humanSex) {
		this.humanSex = humanSex;
	}

	public String getHumanReligion() {
		return this.humanReligion;
	}

	public void setHumanReligion(String humanReligion) {
		this.humanReligion = humanReligion;
	}

	public String getHumanParty() {
		return this.humanParty;
	}

	public void setHumanParty(String humanParty) {
		this.humanParty = humanParty;
	}

	public String getHumanNationality() {
		return this.humanNationality;
	}

	public void setHumanNationality(String humanNationality) {
		this.humanNationality = humanNationality;
	}

	public String getHumanRace() {
		return this.humanRace;
	}

	public void setHumanRace(String humanRace) {
		this.humanRace = humanRace;
	}

	public Timestamp getHumanBirthday() {
		return this.humanBirthday;
	}

	public void setHumanBirthday(Timestamp humanBirthday) {
		this.humanBirthday = humanBirthday;
	}

	public Short getHumanAge() {
		return this.humanAge;
	}

	public void setHumanAge(Short humanAge) {
		this.humanAge = humanAge;
	}

	public String getHumanEducatedDegree() {
		return this.humanEducatedDegree;
	}

	public void setHumanEducatedDegree(String humanEducatedDegree) {
		this.humanEducatedDegree = humanEducatedDegree;
	}

	public Short getHumanEducatedYears() {
		return this.humanEducatedYears;
	}

	public void setHumanEducatedYears(Short humanEducatedYears) {
		this.humanEducatedYears = humanEducatedYears;
	}

	public String getHumanEducatedMajor() {
		return this.humanEducatedMajor;
	}

	public void setHumanEducatedMajor(String humanEducatedMajor) {
		this.humanEducatedMajor = humanEducatedMajor;
	}

	public String getHumanCollege() {
		return this.humanCollege;
	}

	public void setHumanCollege(String humanCollege) {
		this.humanCollege = humanCollege;
	}

	public String getHumanIdcard() {
		return this.humanIdcard;
	}

	public void setHumanIdcard(String humanIdcard) {
		this.humanIdcard = humanIdcard;
	}

	public String getHumanBirthplace() {
		return this.humanBirthplace;
	}

	public void setHumanBirthplace(String humanBirthplace) {
		this.humanBirthplace = humanBirthplace;
	}

	public Double getDemandSalaryStandard() {
		return this.demandSalaryStandard;
	}

	public void setDemandSalaryStandard(Double demandSalaryStandard) {
		this.demandSalaryStandard = demandSalaryStandard;
	}

	public String getHumanHistoryRecords() {
		return this.humanHistoryRecords;
	}

	public void setHumanHistoryRecords(String humanHistoryRecords) {
		this.humanHistoryRecords = humanHistoryRecords;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRecomandation() {
		return this.recomandation;
	}

	public void setRecomandation(String recomandation) {
		this.recomandation = recomandation;
	}

	public String getHumanPicture() {
		return this.humanPicture;
	}

	public void setHumanPicture(String humanPicture) {
		this.humanPicture = humanPicture;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Short getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
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

	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public Short getInterviewStatus() {
		return this.interviewStatus;
	}

	public void setInterviewStatus(Short interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public Double getTotalPoints() {
		return this.totalPoints;
	}

	public void setTotalPoints(Double totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Short getTestAmount() {
		return this.testAmount;
	}

	public void setTestAmount(Short testAmount) {
		this.testAmount = testAmount;
	}

	public String getTestChecker() {
		return this.testChecker;
	}

	public void setTestChecker(String testChecker) {
		this.testChecker = testChecker;
	}

	public Timestamp getTestCheckTime() {
		return this.testCheckTime;
	}

	public void setTestCheckTime(Timestamp testCheckTime) {
		this.testCheckTime = testCheckTime;
	}

	public String getPassRegister() {
		return this.passRegister;
	}

	public void setPassRegister(String passRegister) {
		this.passRegister = passRegister;
	}

	public Timestamp getPassRegistTime() {
		return this.passRegistTime;
	}

	public void setPassRegistTime(Timestamp passRegistTime) {
		this.passRegistTime = passRegistTime;
	}

	public String getPassChecker() {
		return this.passChecker;
	}

	public void setPassChecker(String passChecker) {
		this.passChecker = passChecker;
	}

	public Timestamp getPassCheckTime() {
		return this.passCheckTime;
	}

	public void setPassCheckTime(Timestamp passCheckTime) {
		this.passCheckTime = passCheckTime;
	}

	public Short getPassCheckStatus() {
		return this.passCheckStatus;
	}

	public void setPassCheckStatus(Short passCheckStatus) {
		this.passCheckStatus = passCheckStatus;
	}

	public String getPassCheckComment() {
		return this.passCheckComment;
	}

	public void setPassCheckComment(String passCheckComment) {
		this.passCheckComment = passCheckComment;
	}

	public String getPassPassComment() {
		return this.passPassComment;
	}

	public void setPassPassComment(String passPassComment) {
		this.passPassComment = passPassComment;
	}

}