package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);//typehandler�̿�
	Student selectStudentByNoWithResultMap(Student student);//resultmap�̿�
	List<Student> selectStudentByAll();
	
	Student selectStudentByNoResultMapExtends(Student student);
	
	List<Map<String, Object>> selectStudentMapByAll();
	
	//매개변수를 hashmap로 전달(여러개 입력파라미터전달방법)
	Student selectStudentByMap(Map<String, String> map);
	
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int insertStudentEnum(Student student);

	int updateStudent(Student student);
	int deleteStudent(int id);
}
