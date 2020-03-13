package web.controller.ybc;

import java.io.Serializable;

public class ErrorMassage implements Serializable{
	String errormsg;
	String backurl;
	public ErrorMassage(){}
	public ErrorMassage(String errormsg, String backurl) {
		super();
		this.errormsg = errormsg;
		this.backurl = backurl;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getBackurl() {
		return backurl;
	}
	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}
	
}
