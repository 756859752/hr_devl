package web.controller.ybc.dto;

import java.io.Serializable;

public class Massage implements Serializable{
	String massagetext;
	String backurl;
	public Massage(){}
	public String getMassagetext() {
		return massagetext;
	}
	public void setMassagetext(String massagetext) {
		this.massagetext = massagetext;
	}
	public String getBackurl() {
		return backurl;
	}
	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}
	public Massage(String massagetext, String backurl) {
		super();
		this.massagetext = massagetext;
		this.backurl = backurl;
	}
	
	
}
