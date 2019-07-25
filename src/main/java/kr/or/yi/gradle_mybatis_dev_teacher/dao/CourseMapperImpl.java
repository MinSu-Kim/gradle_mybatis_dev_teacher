package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Course;
import kr.or.yi.gradle_mybatis_dev_teacher.jdbc.MyBatisSqlSessionFactory;

public class CourseMapperImpl implements CourseMapper {
	private String namespace="kr.or.yi.gradle_mybatis_dev_teacher.dao.CourseMapper";
	
	@Override
	public List<Course> selectCoursesByCondition(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace  + ".selectCoursesByCondition", map);
		}
	}

	@Override
	public List<Course> selectCoursesByChoose(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace  + ".selectCoursesByChoose", map);
		}
	}

	@Override
	public List<Course> selectCoursesByTrim(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace  + ".selectCoursesByTrim", map);
		}
	}

	@Override
	public List<Course> selectCoursesByForEach(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace  + ".selectCoursesByForEach", map);
		}
	}

	@Override
	public int insertCourses(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertCourses", map);
			sqlSession.commit();
			return res;
		}
	}

}
