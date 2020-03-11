package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigQuestionFirstKind;

@Repository
public interface ConfigQuestionFirstKindMapper {
	public void insertConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind);
	public void deleteConfigQuestionFirstKind(short id);
	public void updateConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind);
	public ConfigQuestionFirstKind selectConfigQuestionFirstKindById(short id);
	public List<ConfigQuestionFirstKind> selectAllConfigQuestionFirstKind();
}
