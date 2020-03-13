package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrainingMapper;
import pojo.Training;
import service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	TrainingMapper TrainingMapper=null;
	
	@Override
	public void addTraining(Training Training) {
		// TODO Auto-generated method stub
		TrainingMapper.insertTraining(Training);
	}

	@Override
	public void removeTraining(short id) {
		// TODO Auto-generated method stub
		TrainingMapper.deleteTraining(id);
	}

	@Override
	public void alterTraining(Training Training) {
		// TODO Auto-generated method stub
		TrainingMapper.updateTraining(Training);
	}

	@Override
	public Training findTrainingById(short id) {
		// TODO Auto-generated method stub
		return TrainingMapper.selectTrainingById(id);
	}

	@Override
	public List<Training> findAllTraining() {
		// TODO Auto-generated method stub
		return TrainingMapper.selectAllTraining();
	}
	
}
