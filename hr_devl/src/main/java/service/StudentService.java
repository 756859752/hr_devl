package service;

import java.util.List;

import pojo.Student;

public interface StudentService {
	public void removeStudent(int id );
	public boolean addStudent(Student student);
	public	List<Student> findAllStudent();
	public Student findOne(int id);
}
