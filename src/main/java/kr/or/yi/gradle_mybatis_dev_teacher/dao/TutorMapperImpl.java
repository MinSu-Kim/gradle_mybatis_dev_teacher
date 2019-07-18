package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Tutor;
import kr.or.yi.gradle_mybatis_dev_teacher.jdbc.MyBatisSqlSessionFactory;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev_teacher.dao.TutorMapper";

	@Override
	public Tutor selectTutorById(Tutor tutor) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectTutorById", tutor);
		}
	}

}
