package web.controller.dcf.dto;

import java.util.List;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import pojo.ConfigMajor;
import pojo.ConfigMajorKind;

public class ChooseConditionsDto {
    private List<ConfigFileFirstKind> first;
    private List<ConfigFileSecondKind> second;
    private List<ConfigFileThirdKind> third;
    private List<ConfigMajor> major;
    private List<ConfigMajorKind> majorkind;
	public List<ConfigFileFirstKind> getFirst() {
		return first;
	}
	public void setFirst(List<ConfigFileFirstKind> first) {
		this.first = first;
	}
	public List<ConfigFileSecondKind> getSecond() {
		return second;
	}
	public void setSecond(List<ConfigFileSecondKind> second) {
		this.second = second;
	}
	public List<ConfigFileThirdKind> getThird() {
		return third;
	}
	public void setThird(List<ConfigFileThirdKind> third) {
		this.third = third;
	}
	public List<ConfigMajor> getMajor() {
		return major;
	}
	public void setMajor(List<ConfigMajor> major) {
		this.major = major;
	}
	public List<ConfigMajorKind> getMajorkind() {
		return majorkind;
	}
	public void setMajorkind(List<ConfigMajorKind> majorkind) {
		this.majorkind = majorkind;
	}
    
}
