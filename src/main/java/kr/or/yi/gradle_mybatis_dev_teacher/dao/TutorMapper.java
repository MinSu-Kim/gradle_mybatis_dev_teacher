package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorById(Tutor tutor);
}
