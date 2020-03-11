package dao;

import java.util.List;

import pojo.Training;

public interface TrainingMapper {
	public void insertTraining(Training SalaryGrantDetail);
	public void deleteTraining(short id);
	public void updateTraining(Training SalaryGrantDetail);
	public Training selectTrainingById(short id);
	public List<Training> selectAllTraining();
}
