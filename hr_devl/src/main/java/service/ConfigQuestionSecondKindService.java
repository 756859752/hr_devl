package service;

import java.util.List;

import pojo.ConfigQuestionSecondKind;



public interface ConfigQuestionSecondKindService {
	public void addConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind);

	public void removeConfigQuestionSecondKind(short id);
	public void removeConfigQuestionSecondKindByfirstKindId(String firstKindId);
	public void alterConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind);

	public ConfigQuestionSecondKind ConfigQuestionSecondKindById(short id);

	public List<ConfigQuestionSecondKind> findAllConfigQuestionSecondKind();
}
