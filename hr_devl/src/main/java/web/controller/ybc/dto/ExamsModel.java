package web.controller.ybc.dto;

import java.util.ArrayList;
import java.util.List;

import pojo.EngageExamDetails;

public class ExamsModel {
	private List<EngageExamDetails> examdetails =new ArrayList<>();
	
	public void setExamdetails(List<EngageExamDetails> examdetails){
		this.examdetails=examdetails;
	}
	public List<EngageExamDetails> getExamdetails(){
		return this.examdetails;
	}
	public ExamsModel(List<EngageExamDetails> examdetails){
		super();
		this.examdetails=examdetails;
	}
	public ExamsModel(){
		super();
	}
}
