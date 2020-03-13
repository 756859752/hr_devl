package service;

import java.util.List;

import pojo.ConfigQuestionFirstKind;



public interface ConfigQuestionFirstKindService {
	public void addConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind);

	public void removeConfigQuestionFirstKind(short id);

	public void alterConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind);

	public ConfigQuestionFirstKind ConfigQuestionFirstKindById(short id);

	public List<ConfigQuestionFirstKind> findAllConfigQuestionFirstKind();
}
