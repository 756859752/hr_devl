package web.controller.ybc.dto;

import java.util.ArrayList;
import java.util.List;

import pojo.EngageAnswer;
import pojo.EngageAnswerDetails;
import pojo.EngageExamDetails;

public class AnswerModel {
private List<EngageAnswerDetails> answers =new ArrayList<>();
	public List<EngageAnswerDetails> getAnswers() {
		return answers;
	}
	public void setAnswers(List<EngageAnswerDetails> answers) {
		this.answers = answers;
	}
	public AnswerModel(List<EngageAnswerDetails> answers){
		super();
		this.answers=answers;
	}
	public AnswerModel(){
		super();
	}
}
