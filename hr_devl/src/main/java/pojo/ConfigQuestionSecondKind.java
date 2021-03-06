package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * ConfigQuestionSecondKind entity. @author MyEclipse Persistence Tools
 */

public class ConfigQuestionSecondKind implements java.io.Serializable {

	// Fields

	private Short qskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private List<EngageSubjects> list=new ArrayList<>(); 
	// Constructors

	/** default constructor */
	public ConfigQuestionSecondKind() {
	}

	/** full constructor */
	public ConfigQuestionSecondKind(String firstKindId, String firstKindName, String secondKindId,
			String secondKindName) {
		this.firstKindId = firstKindId;
		this.firstKindName = firstKindName;
		this.secondKindId = secondKindId;
		this.secondKindName = secondKindName;
	}

	// Property accessors

	public Short getQskId() {
		return this.qskId;
	}

	public void setQskId(Short qskId) {
		this.qskId = qskId;
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

	@Override
	public String toString() {
		return "ConfigQuestionSecondKind [qskId=" + qskId + ", firstKindId=" + firstKindId + ", firstKindName="
				+ firstKindName + ", secondKindId=" + secondKindId + ", secondKindName=" + secondKindName + "]";
	}

	public List<EngageSubjects> getList() {
		return list;
	}

	public void setList(List<EngageSubjects> list) {
		this.list = list;
	}
	public int getSubjectsize(){
		return	this.list.size();
	}
	
}