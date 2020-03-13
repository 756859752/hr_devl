package service;

import java.util.List;

import pojo.Training;

public interface TrainingService{
	public void addTraining(Training TrainingDetail);
	public void removeTraining(short id);
	public void alterTraining(Training TrainingDetail);
	public Training findTrainingById(short id);
	public List<Training> findAllTraining();
}
