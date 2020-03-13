package dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigQuestionSecondKind;

@RequestMapping
public interface ConfigQuestionSecondKindMapper {
	public void insertConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind);

	public void deleteConfigQuestionSecondKind(short id);

	public void updateConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind);

	public ConfigQuestionSecondKind selectConfigQuestionSecondKindById(short id);

	public List<ConfigQuestionSecondKind> selectAllConfigQuestionSecondKind();
}
