package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);//typehandler�̿�
	Student selectStudentByNoWithResultMap(Student student);//resultmap�̿�
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);

	int updateStudent(Student student);
	int deleteStudent(int id);
}
