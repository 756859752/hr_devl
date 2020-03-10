package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.Student;

@Repository
public interface StudentMapper {
	public boolean insertStudent(Student student);
	public boolean deleteStudent(int id);
	public Student selectStudentById(int id);
	public List<Student> selectAll();
}
