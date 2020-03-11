package  pojo;

import java.sql.Timestamp;

/**
 * HumanFileDig entity. @author MyEclipse Persistence Tools
 */

public class HumanFileDig implements java.io.Serializable {

	// Fields

	private Short hfdId;
	private String humanId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String humanName;
	private String humanAddress;
	private String humanPostcode;
	private String humanProDesignation;
	private String humanMajorKindId;
	private String humanMajorKindName;
	private String humanMajorId;
	private String hunmaMajorName;
	private String humanTelephone;
	private String humanMobilephone;
	private String humanBank;
	private String humanAccount;
	private String humanQq;
	private String humanEmail;
	private String humanHobby;
	private String humanSpeciality;
	private String humanSex;
	private String humanReligion;
	private String humanParty;
	private String humanNationality;
	private String humanRace;
	private Timestamp humanBirthday;
	private String humanBirthplace;
	private Short humanAge;
	private String humanEducatedDegree;
	private Short humanEducatedYears;
	private String humanEducatedMajor;
	private String humanSocietySecurityId;
	private String humanIdCard;
	private String remark;
	private String salaryStandardId;
	private String salaryStandardName;
	private Double salarySum;
	private Double demandSalaraySum;
	private Double paidSalarySum;
	private Short majorChangeAmount;
	private Short bonusAmount;
	private Short trainingAmount;
	private Short fileChangAmount;
	private String humanHistroyRecords;
	private String humanFamilyMembership;
	private String humanPicture;
	private String attachmentName;
	private Short checkStatus;
	private String register;
	private String checker;
	private String changer;
	private Timestamp registTime;
	private Timestamp checkTime;
	private Timestamp changeTime;
	private Timestamp lastlyChangeTime;
	private Timestamp deleteTime;
	private Timestamp recoveryTime;
	private Short humanFileStatus;

	// Constructors

	/** default constructor */
	public HumanFileDig() {
	}

	/** minimal constructor */
	public HumanFileDig(Timestamp humanBirthday, Timestamp registTime, Timestamp checkTime, Timestamp changeTime,
			Timestamp lastlyChangeTime, Timestamp deleteTime, Timestamp recoveryTime) {
		this.humanBirthday = humanBirthday;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.changeTime = changeTime;
		this.lastlyChangeTime = lastlyChangeTime;
		this.deleteTime = deleteTime;
		this.recoveryTime = recoveryTime;
	}

	/** full constructor */
	public HumanFileDig(String humanId, String firstKindId, String firstKindName, String secondKindId,
			String secondKindName, String thirdKindId, String thirdKindName, String humanName, String humanAddress,
			String humanPostcode, String humanProDesignation, String humanMajorKindId, String humanMajorKindName,
			String humanMajorId, String hunmaMajorName, String humanTelephone, String humanMobilephone,
			String humanBank, String humanAccount, String humanQq, String humanEmail, String humanHobby,
			String humanSpeciality, String humanSex, String humanReligion, String humanParty, String humanNationality,
			String humanRace, Timestamp humanBirthday, String humanBirthplace, Short humanAge,
			String humanEducatedDegree, Short humanEducatedYears, String humanEducatedMajor,
			String humanSocietySecurityId, String humanIdCard, String remark, String salaryStandardId,
			String salaryStandardName, Double salarySum, Double demandSalaraySum, Double paidSalarySum,
			Short majorChangeAmount, Short bonusAmount, Short trainingAmount, Short fileChangAmount,
			String humanHistroyRecords, String humanFamilyMembership, String humanPicture, String attachmentName,
			Short checkStatus, String register, String checker, String changer, Timestamp registTime,
			Timestamp checkTime, Timestamp changeTime, Timestamp lastlyChangeTime, Timestamp deleteTime,
			Timestamp recoveryTime, Short humanFileStatus) {
		this.humanId = humanId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.humanName = humanName;
		this.humanAddress = humanAddress;
		this.humanPostcode = humanPostcode;
		this.humanProDesignation = humanProDesignation;
		this.humanMajorKindId = humanMajorKindId;
		this.humanMajorKindName = humanMajorKindName;
		this.humanMajorId = humanMajorId;
		this.hunmaMajorName = hunmaMajorName;
		this.humanTelephone = humanTelephone;
		this.humanMobilephone = humanMobilephone;
		this.humanBank = humanBank;
		this.humanAccount = humanAccount;
		this.humanQq = humanQq;
		this.humanEmail = humanEmail;
		this.humanHobby = humanHobby;
		this.humanSpeciality = humanSpeciality;
		this.humanSex = humanSex;
		this.humanReligion = humanReligion;
		this.humanParty = humanParty;
		this.humanNationality = humanNationality;
		this.humanRace = humanRace;
		this.humanBirthday = humanBirthday;
		this.humanBirthplace = humanBirthplace;
		this.humanAge = humanAge;
		this.humanEducatedDegree = humanEducatedDegree;
		this.humanEducatedYears = humanEducatedYears;
		this.humanEducatedMajor = humanEducatedMajor;
		this.humanSocietySecurityId = humanSocietySecurityId;
		this.humanIdCard = humanIdCard;
		this.remark = remark;
		this.salaryStandardId = salaryStandardId;
		this.salaryStandardName = salaryStandardName;
		this.salarySum = salarySum;
		this.demandSalaraySum = demandSalaraySum;
		this.paidSalarySum = paidSalarySum;
		this.majorChangeAmount = majorChangeAmount;
		this.bonusAmount = bonusAmount;
		this.trainingAmount = trainingAmount;
		this.fileChangAmount = fileChangAmount;
		this.humanHistroyRecords = humanHistroyRecords;
		this.humanFamilyMembership = humanFamilyMembership;
		this.humanPicture = humanPicture;
		this.attachmentName = attachmentName;
		this.checkStatus = checkStatus;
		this.register = register;
		this.checker = checker;
		this.changer = changer;
		this.registTime = registTime;
		this.checkTime = checkTime;
		this.changeTime = changeTime;
		this.lastlyChangeTime = lastlyChangeTime;
		this.deleteTime = deleteTime;
		this.recoveryTime = recoveryTime;
		this.humanFileStatus = humanFileStatus;
	}


	public Short getHfdId() {
		return this.hfdId;
	}

	public void setHfdId(Short hfdId) {
		this.hfdId = hfdId;
	}


	public String getHumanId() {
		return this.humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
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


	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
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


	public String getHumanProDesignation() {
		return this.humanProDesignation;
	}

	public void setHumanProDesignation(String humanProDesignation) {
		this.humanProDesignation = humanProDesignation;
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


	public String getHunmaMajorName() {
		return this.hunmaMajorName;
	}

	public void setHunmaMajorName(String hunmaMajorName) {
		this.hunmaMajorName = hunmaMajorName;
	}


	public String getHumanTelephone() {
		return this.humanTelephone;
	}

	public void setHumanTelephone(String humanTelephone) {
		this.humanTelephone = humanTelephone;
	}


	public String getHumanMobilephone() {
		return this.humanMobilephone;
	}

	public void setHumanMobilephone(String humanMobilephone) {
		this.humanMobilephone = humanMobilephone;
	}


	public String getHumanBank() {
		return this.humanBank;
	}

	public void setHumanBank(String humanBank) {
		this.humanBank = humanBank;
	}


	public String getHumanAccount() {
		return this.humanAccount;
	}

	public void setHumanAccount(String humanAccount) {
		this.humanAccount = humanAccount;
	}


	public String getHumanQq() {
		return this.humanQq;
	}

	public void setHumanQq(String humanQq) {
		this.humanQq = humanQq;
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


	public String getHumanSpeciality() {
		return this.humanSpeciality;
	}

	public void setHumanSpeciality(String humanSpeciality) {
		this.humanSpeciality = humanSpeciality;
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


	public String getHumanBirthplace() {
		return this.humanBirthplace;
	}

	public void setHumanBirthplace(String humanBirthplace) {
		this.humanBirthplace = humanBirthplace;
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


	public String getHumanSocietySecurityId() {
		return this.humanSocietySecurityId;
	}

	public void setHumanSocietySecurityId(String humanSocietySecurityId) {
		this.humanSocietySecurityId = humanSocietySecurityId;
	}


	public String getHumanIdCard() {
		return this.humanIdCard;
	}

	public void setHumanIdCard(String humanIdCard) {
		this.humanIdCard = humanIdCard;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSalaryStandardId() {
		return this.salaryStandardId;
	}

	public void setSalaryStandardId(String salaryStandardId) {
		this.salaryStandardId = salaryStandardId;
	}


	public String getSalaryStandardName() {
		return this.salaryStandardName;
	}

	public void setSalaryStandardName(String salaryStandardName) {
		this.salaryStandardName = salaryStandardName;
	}


	public Double getSalarySum() {
		return this.salarySum;
	}

	public void setSalarySum(Double salarySum) {
		this.salarySum = salarySum;
	}


	public Double getDemandSalaraySum() {
		return this.demandSalaraySum;
	}

	public void setDemandSalaraySum(Double demandSalaraySum) {
		this.demandSalaraySum = demandSalaraySum;
	}


	public Double getPaidSalarySum() {
		return this.paidSalarySum;
	}

	public void setPaidSalarySum(Double paidSalarySum) {
		this.paidSalarySum = paidSalarySum;
	}


	public Short getMajorChangeAmount() {
		return this.majorChangeAmount;
	}

	public void setMajorChangeAmount(Short majorChangeAmount) {
		this.majorChangeAmount = majorChangeAmount;
	}


	public Short getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(Short bonusAmount) {
		this.bonusAmount = bonusAmount;
	}


	public Short getTrainingAmount() {
		return this.trainingAmount;
	}

	public void setTrainingAmount(Short trainingAmount) {
		this.trainingAmount = trainingAmount;
	}


	public Short getFileChangAmount() {
		return this.fileChangAmount;
	}

	public void setFileChangAmount(Short fileChangAmount) {
		this.fileChangAmount = fileChangAmount;
	}


	public String getHumanHistroyRecords() {
		return this.humanHistroyRecords;
	}

	public void setHumanHistroyRecords(String humanHistroyRecords) {
		this.humanHistroyRecords = humanHistroyRecords;
	}


	public String getHumanFamilyMembership() {
		return this.humanFamilyMembership;
	}

	public void setHumanFamilyMembership(String humanFamilyMembership) {
		this.humanFamilyMembership = humanFamilyMembership;
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


	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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


	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}


	public Timestamp getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}


	public Timestamp getLastlyChangeTime() {
		return this.lastlyChangeTime;
	}

	public void setLastlyChangeTime(Timestamp lastlyChangeTime) {
		this.lastlyChangeTime = lastlyChangeTime;
	}


	public Timestamp getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}


	public Timestamp getRecoveryTime() {
		return this.recoveryTime;
	}

	public void setRecoveryTime(Timestamp recoveryTime) {
		this.recoveryTime = recoveryTime;
	}


	public Short getHumanFileStatus() {
		return this.humanFileStatus;
	}

	public void setHumanFileStatus(Short humanFileStatus) {
		this.humanFileStatus = humanFileStatus;
	}

}