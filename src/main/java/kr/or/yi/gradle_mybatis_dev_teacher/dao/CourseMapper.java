package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Course;

public interface CourseMapper {
	List<Course> selectCoursesByCondition(Map<String, Object> map);
	List<Course> selectCoursesByChoose(Map<String, Object> map);
	List<Course> selectCoursesByTrim(Map<String, Object> map);
	List<Course> selectCoursesByForEach(Map<String, Object> map);
	int insertCourses(Map<String, Object> map);
}
