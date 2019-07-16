package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);//typehandler이용
	Student selectStudentByNoWithResultMap(Student student);//resultmap이용
}
