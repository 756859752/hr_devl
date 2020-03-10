package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentMapper;
import pojo.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper=null;
	
	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		studentMapper.deleteStudent(id);
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentMapper.insertStudent(student);
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectAll();
	}

	@Override
	public Student findOne(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentById(id);
	}
	
}	
