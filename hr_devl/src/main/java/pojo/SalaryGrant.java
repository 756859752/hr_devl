package pojo;

import java.sql.Timestamp;

/**
 * SalaryGrant entity. @author MyEclipse Persistence Tools
 */

public class SalaryGrant implements java.io.Serializable {

	// Fields

	private Short sgrId;
	private String salaryGrantId;
	private String salaryStandardId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private Short humanAmount;
	private Double salaryStandardSum;
	private Double salaryPaidSum;
	private String register;
	private Timestamp registTime;
	private String checker;
	private Timestamp checkTime;
	private Short checkStatus;

	// Constructors

	/** default constructor */
	public SalaryGrant() {
	}

	/** minimal constructor */
	public SalaryGrant(Timestamp registTime, Timestamp checkTime) {
		this.registTime = registTime;
		this.checkTime = checkTime;
	}

	/** full constructor */
	public SalaryGrant(String salaryGrantId, String salaryStandardId, String firstKindId, String firstKindName,
			String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, Short humanAmount,
			Double salaryStandardSum, Double salaryPaidSum, String register, Timestamp registTime, String checker,
			Timestamp checkTime, Short checkStatus) {
		this.salaryGrantId = salaryGrantId;
		this.salaryStandardId = salaryStandardId;
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
		this.thirdKindId = thirdKindId;
		this.thirdKindName = thirdKindName;
		this.humanAmount = humanAmount;
		this.salaryStandardSum = salaryStandardSum;
		this.salaryPaidSum = salaryPaidSum;
		this.register = register;
		this.registTime = registTime;
		this.checker = checker;
		this.checkTime = checkTime;
		this.checkStatus = checkStatus;
	}

	public Short getSgrId() {
		return this.sgrId;
	}

	public void setSgrId(Short sgrId) {
		this.sgrId = sgrId;
	}

	public String getSalaryGrantId() {
		return this.salaryGrantId;
	}

	public void setSalaryGrantId(String salaryGrantId) {
		this.salaryGrantId = salaryGrantId;
	}

	public String getSalaryStandardId() {
		return this.salaryStandardId;
	}

	public void setSalaryStandardId(String salaryStandardId) {
		this.salaryStandardId = salaryStandardId;
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

	public Short getHumanAmount() {
		return this.humanAmount;
	}

	public void setHumanAmount(Short humanAmount) {
		this.humanAmount = humanAmount;
	}

	public Double getSalaryStandardSum() {
		return this.salaryStandardSum;
	}

	public void setSalaryStandardSum(Double salaryStandardSum) {
		this.salaryStandardSum = salaryStandardSum;
	}

	public Double getSalaryPaidSum() {
		return this.salaryPaidSum;
	}

	public void setSalaryPaidSum(Double salaryPaidSum) {
		this.salaryPaidSum = salaryPaidSum;
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

	public Short getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
	}

}